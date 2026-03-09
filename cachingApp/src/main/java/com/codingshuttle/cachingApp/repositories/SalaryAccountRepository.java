package com.codingshuttle.cachingApp.repositories;

import com.codingshuttle.cachingApp.entities.SalaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryAccountRepository extends JpaRepository<SalaryAccount, Long> {
}
