package com.transaccion.backend.test.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {

	private Long id;
	private String comment;
	private String type;
	private LocalDateTime creationDate;

}
