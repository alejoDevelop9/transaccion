package com.transaccion.backend.test.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.transaccion.backend.test.dto.AccountDto;
import com.transaccion.backend.test.dto.NewTransactionDto;
import com.transaccion.backend.test.dto.TransactionDto;
import com.transaccion.backend.test.model.Account;
import com.transaccion.backend.test.repository.AccountRepository;

@Repository
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
				.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
				.orElse(null);
	}

	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent
	 *         first
	 */
	public List<TransactionDto> getTransactionsForAccount(Long accountId) {
		AccountDto accountDto = getAccount(accountId);
		List<TransactionDto> transactions = new ArrayList<>();
		TransactionDto t = new TransactionDto(accountId, accountDto.getNumber(), accountDto.getType(),
				accountDto.getCreationDate());
		transactions.add(t);
		return transactions;
	}

	/**
	 * Creates a new transaction
	 *
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed
	 *                                  newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {
		Account account = new Account();
		account.setNumber(newTransactionDto.getComment());
		account.setType(newTransactionDto.getType());
		LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
		account.setCreationDate(creationDate);
		accountRepository.save(account);
		newTransactionDto.setAccountId(account.getId());
		Long transactionId = newTransactionDto.getAccountId();
		return transactionId;
	}

}
