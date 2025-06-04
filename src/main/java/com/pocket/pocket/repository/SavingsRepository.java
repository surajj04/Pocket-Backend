package com.pocket.pocket.repository;

import com.pocket.pocket.model.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Integer> {

    Savings findByUserId(int userId);
}
