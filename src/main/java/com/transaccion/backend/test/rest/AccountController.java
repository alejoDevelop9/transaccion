package com.transaccion.backend.test.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transaccion.backend.test.dto.AccountDto;
import com.transaccion.backend.test.dto.NewTransactionDto;
import com.transaccion.backend.test.dto.TransactionDto;
import com.transaccion.backend.test.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService aService;

	public AccountController(AccountService accountService) {
		this.aService = accountService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountDto getAccount(@PathVariable Long id) {
		log.info("iniciando get");
		return aService.getAccount(id);
	}

	// obtiene la lista
	@GetMapping(value = "/{id}/transactions")
	@ResponseStatus(HttpStatus.OK)
	List<TransactionDto> getTransactionsForAccount(@PathVariable Long id) {
		log.info("metodo de get transaccion for account: " + id);
		return aService.getTransactionsForAccount(id);
	}

	// agrega la nueva transaccion
	@PostMapping("/{id}/transactions")
	public void addTransaccion(@RequestBody NewTransactionDto nuevaTransaccion) {
		log.info("metodo de new transaccion: " + nuevaTransaccion);
		aService.addTransaction(nuevaTransaccion);
	}

}
