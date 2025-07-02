package com.BTS.statementservice.exception;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String respMsg;
	private String respCode;

	public BusinessException(String respCode,String respMsg) {
		{
			this.respMsg=respMsg;
			this.respCode=respCode;
		}

	}

}