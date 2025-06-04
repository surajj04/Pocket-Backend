package com.pocket.pocket.service;

import com.pocket.pocket.model.Budget;
import com.pocket.pocket.repository.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepo budgetRepo;
    @Autowired
    private SavingsService savingsService;

    public List<Budget> getBudgetByUserId(int userId) {
        return budgetRepo.findByUserId(userId);
    }

    public Budget addBudget(Budget budget) {
        Date date = new Date();
        budget.setDate(date);

        List<Budget> budgetList = getBudgetByUserId(budget.getUserId());
        double savings = 0;
        for (Budget b : budgetList) {
            savings += b.getCurrentBalance();
        }
        if (savingsService.updateSavings(savings, budget.getUserId()) != null) {
            return budgetRepo.save(budget);
        }
        return null;
    }

    public Budget updateBudget(Budget budget) {
        return budgetRepo.save(budget);
    }
}
