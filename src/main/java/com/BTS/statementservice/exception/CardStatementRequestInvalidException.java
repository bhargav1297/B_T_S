package com.BTS.statementservice.exception;

import lombok.Getter;

@Getter
public class CardStatementRequestInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String respMsg;
	private String respCode;

	public CardStatementRequestInvalidException(String respCode,String respMsg) {
		{
			this.respMsg=respMsg;
			this.respCode=respCode;
		}

	}

}
