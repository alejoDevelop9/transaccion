package com.transaccion.backend.test.rest;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;

import com.transaccion.backend.test.dto.AccountDto;

public class AccountControllerTest extends AbstractControllerTest {

	@Test
	public void shouldReturnFoundAccount() throws Exception {
		// given
		LocalDateTime creationDate = LocalDateTime.of(2020, 9, 21, 15, 00, 16);
		AccountDto account = new AccountDto("001", "saving", creationDate);

		// when
		when(accountService.getAccount(1L)).thenReturn(account);

		// then
		mockMvc.perform(get("/accounts/1").accept(APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.number", is("001")))
				.andExpect(jsonPath("$.type", is("saving")))
				.andExpect(jsonPath("$.creationDate", is(creationDate.toString())));

	}
}
