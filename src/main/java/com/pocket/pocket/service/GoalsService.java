package com.pocket.pocket.service;

import com.pocket.pocket.model.Goals;
import com.pocket.pocket.model.SavingGoal;
import com.pocket.pocket.repository.GoalsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsService {

    @Autowired
    private GoalsRepo goalsRepo;
    @Autowired
    private SavingsService savingsService;

    public List<Goals> findGoalByUserId(int userId) {
        return goalsRepo.findByUserId(userId);
    }

    public Goals addGoal(Goals goal) {
        return goalsRepo.save(goal);
    }

    public Goals updateGoal(SavingGoal goal) {

        Goals g = goalsRepo.findById(goal.getId()).orElse(null);
        if (g != null) {
            if (g.getUserId() == goal.getUserId()) {
                savingsService.debitSaving(goal.getAmount(), goal.getUserId());
                g.setAmount(g.getAmount() + goal.getAmount());
                g.setTargetAmount(g.getTargetAmount() - goal.getAmount());
                return goalsRepo.save(g);
            }
        }
        return null;
    }

    public void deleteGoal(int id) {
        goalsRepo.deleteById(id);
    }

    public List<Goals> getAllGoals(int id) {
        return goalsRepo.findByUserId(id);
    }

}
