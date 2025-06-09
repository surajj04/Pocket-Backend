package com.pocket.pocket.service;

import com.pocket.pocket.model.*;
import com.pocket.pocket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BudgetRepo budgetRepo;
    @Autowired
    private ExpenseRepo expenseRepo;
    @Autowired
    private GoalsRepo goalsRepo;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private SavingsService savingsService;


    @Autowired
    private PasswordEncoder encoder;

    private static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        try {
            String encryptedPassword = encoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            String token = generateToken();

            if (!verifyToken(token)) {
                token = generateToken();
                if (!verifyToken(token)) {
                    throw new RuntimeException("Failed to generate a valid token.");
                }
            }
            user.setToken(token);
            return userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Email already exists. Please use a different one.");
        } catch (Exception e) {
            throw new RuntimeException("Registration failed: " + e.getMessage());
        }
    }


    public boolean validatePassword(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) return false;

        boolean passwordMatch = encoder.matches(password, user.getPassword());
        if (!passwordMatch) return false;

        String token = generateToken();
        if (!verifyToken(token)) {
            token = generateToken();
            if (!verifyToken(token)) {
                return false;
            }
        }

        user.setToken(token);
        userRepo.save(user);
        return true;
    }


    public String getToken(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                return user.getToken();
            }
        }
        return null;
    }

    private boolean verifyToken(String token) {
        return !userRepo.existsByToken(token);
    }

    public boolean validateToken(String token) {
        return !verifyToken(token);
    }

    public void logoutToken(String token) {
        userRepo.clearToken(token);
    }

    public UserDetail getUserDetail(String token) {
        UserDetail user = new UserDetail();
        User temp = userRepo.findByToken(token);

        user.setUserId(temp.getUserId());
        user.setName(temp.getName());
        user.setGender(temp.getGender());
        user.setDob(temp.getDob());
        user.setEmail(temp.getEmail());
        user.setBudgets(budgetRepo.findByUserId(user.getUserId()));
        user.setExpenses(expenseRepo.findByUserId(user.getUserId()));
        user.setGoals(goalsRepo.findByUserId(user.getUserId()));
        user.setToken(temp.getToken());
        user.setTotalExpense(expenseService.getTotalExpense(user.getUserId()));
        user.setPhoneNo(temp.getPhoneNo());
        user.setSavings(savingsService.getSavingsByUserId(temp.getUserId()));
        user.setCountry(temp.getCountry());
        user.setState(temp.getState());
        user.setCity(temp.getCity());
        return user;
    }

    public UpdateUser updateEmail(UpdateUser user) {
        User user1 = userRepo.findById(user.getUserId()).orElse(new User());
        user1.setEmail(user.getEmail());
        User result = userRepo.save(user1);
        if (result.getUserId() != 0) {
            return user;
        }
        return null;
    }

    public UpdateUser updateName(UpdateUser user) {
        User user1 = userRepo.findById(user.getUserId()).orElse(new User());
        user1.setName(user.getName());
        User result = userRepo.save(user1);
        if (result.getUserId() != 0) {
            return user;
        }
        return null;
    }

    public UpdateUser updatePassword(UpdateUser user) {
        User user1 = userRepo.findById(user.getUserId()).orElse(new User());

        boolean oldPass = encoder.matches(user.getOldPassword(), user1.getPassword());
        if (oldPass) {
            String newPassword = encoder.encode(user.getNewPassword());
            user1.setPassword(newPassword);
            User result = userRepo.save(user1);
            if (result.getUserId() != 0) {
                return user;
            }
            return null;
        }
        return null;
    }

    public void deleteUser(String token) {
        int userId = userRepo.findByToken(token).getUserId();
        budgetRepo.deleteBudgetByUserId(userId);
        expenseRepo.deleteByUserId(userId);
        goalsRepo.deleteByUserId(userId);
        userRepo.deleteUserByToken(token);
    }

    public User getUserDetail(int userId) {
        User user = new User();
        User temp = userRepo.findById(userId).orElse(new User());

        user.setGender(temp.getGender());
        user.setName(temp.getName());
        user.setDob(temp.getDob());

        return user;
    }

    public List<Report> getReport(int id) {
        List<Report> reports = new ArrayList<>();

        List<Budget> budgets = budgetRepo.findByUserId(id);

        double[] categoryValues = getAllValues(id);

        for (Budget b : budgets) {
            String HASHID = UUID.randomUUID().toString();
            Report r = new Report();
            r.setId(HASHID);
            r.setMonth(b.getDate().toString());
            r.setAmount(b.getCurrentBalance());
            r.setFood(categoryValues[0]);
            r.setBills(categoryValues[1]);
            r.setTravel(categoryValues[2]);
            r.setOther(categoryValues[3]);
            r.setShopping(categoryValues[4]);

            reports.add(r);
        }

        return reports;
    }

    public double[] getAllValues(int id) {
        List<Expense> expenses = expenseRepo.findByUserId(id);

        double food = 0;
        double bills = 0;
        double travel = 0;
        double shopping = 0;
        double other = 0;

        for (Expense e : expenses) {
            switch (e.getCategory()) {
                case "Food":
                    food += e.getAmount();
                    break;
                case "Bills":
                    bills += e.getAmount();
                    break;
                case "Travel":
                    travel += e.getAmount();
                    break;
                case "Shopping":
                    travel += e.getAmount();
                    break;
                case "Other":
                    other += e.getAmount();
                    break;
            }
        }

        return new double[]{food, bills, travel, other, shopping};
    }


    public static String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int month = calendar.get(Calendar.MONTH);

        String[] months = {"Jan", "Feb", "March", "April", "May", "June",
                "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

        return months[month];
    }

    public UserDetail updateUser(UserDetail user) {
        User temp = userRepo.findById(user.getUserId()).orElse(new User());
        if (temp != null) {

            temp.setName(user.getName());
            temp.setGender(user.getGender());
            temp.setDob(user.getDob());
            temp.setEmail(user.getEmail());
            temp.setPhoneNo(user.getPhoneNo());
            temp.setCountry(user.getCountry());
            temp.setState(user.getState());
            temp.setCity(user.getCity());
            userRepo.save(temp);

            return user;
        }
        return null;
    }

    public int getUserIdByPhoneNo(String phoneNo) {
        User temp = userRepo.findByPhoneNo(phoneNo);
        return temp.getUserId();
    }

    public boolean sendOtp(String email) {
        return true;
    }

    public boolean setValidUser(String otp) {
        return true;
    }

}
