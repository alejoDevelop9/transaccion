package com.transaccion.backend.test.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AccountDto {

	private String number;
	private String type;
	private LocalDateTime creationDate;

}
