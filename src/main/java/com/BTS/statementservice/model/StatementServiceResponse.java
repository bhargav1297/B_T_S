package com.BTS.statementservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value=Include.NON_NULL)
public class StatementServiceResponse {
	
	private StatusBlock stblock;
	private CardDetailsFromDB cdetails;

}
