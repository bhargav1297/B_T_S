package com.BTS.statementservice.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.exception.CardStatementRequestInvalidException;
import com.BTS.statementservice.exception.SystemException;
import com.BTS.statementservice.model.StatementServiceResponse;
import com.BTS.statementservice.model.StatusBlock;

@ControllerAdvice
public class CardRewardControllerAdvice {

	@ExceptionHandler(value = CardStatementRequestInvalidException.class)
	@ResponseBody
	public StatementServiceResponse handleCardStatementRequestInvalidException(
			CardStatementRequestInvalidException cardInfoException) {

		StatementServiceResponse response = buildStatusBlockResp(cardInfoException.getRespCode(), cardInfoException.getRespMsg());

		return response;

	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public StatementServiceResponse handleBusinessException(BusinessException bException) {

		StatementServiceResponse response = buildStatusBlockResp(bException.getRespCode(), bException.getRespMsg());

		return response;

	}

	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public StatementServiceResponse handelSystemException(SystemException sException) {

		StatementServiceResponse response = buildStatusBlockResp(sException.getRespCode(), sException.getRespMsg());

		return response;

	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public StatementServiceResponse handelUnknowException(Exception exception) {

		StatementServiceResponse response = buildStatusBlockResp("999", "Unknow generic exception");

		return response;

	}

	private StatementServiceResponse buildStatusBlockResp(String respCode, String respMsg) {
		StatementServiceResponse response = new StatementServiceResponse();

		StatusBlock stblock = new StatusBlock();
		stblock.setRespCode(respCode);
		stblock.setRespMsg(respMsg);

		response.setStblock(stblock);
	
		return response;
	}

}
