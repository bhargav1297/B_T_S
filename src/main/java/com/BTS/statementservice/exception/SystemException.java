package com.BTS.statementservice.exception;

import lombok.Getter;

@Getter
public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String respMsg;	
	private String respCode;

	public SystemException(String respMsg, String respCode) {
		super();
		this.respMsg = respMsg;
		this.respCode = respCode;
	}
	

}
