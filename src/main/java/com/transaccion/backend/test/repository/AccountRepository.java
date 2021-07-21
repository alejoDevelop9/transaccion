package com.transaccion.backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaccion.backend.test.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
