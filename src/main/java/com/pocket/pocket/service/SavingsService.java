package com.pocket.pocket.service;

import com.pocket.pocket.model.Savings;
import com.pocket.pocket.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public Savings getSavingsByUserId(int userId) {
        return savingsRepository.findByUserId(userId);
    }

    public Savings updateSavings(double savings, int userId) {
        Savings s1 = savingsRepository.findByUserId(userId);
        if (s1 != null) {
            s1.setSavings(s1.getSavings() + savings);
            return s1;
        }
        Savings s2 = new Savings();
        s2.setSavings(savings);
        s2.setUserId(userId);
        return savingsRepository.save(s2);
    }

    public Savings debitSaving(double savings, int userId) {
        Savings s1 = savingsRepository.findByUserId(userId);
        if (s1 != null) {
            s1.setSavings(s1.getSavings() - savings);
            return savingsRepository.save(s1);
        }
        return null;
    }
}
