package com.BTS.statementservice.service;

import java.util.List;

import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.exception.SystemException;
import com.BTS.statementservice.model.CardDetailsFromDB;
import com.BTS.statementservice.model.CardInfo;

public interface StatementService {
	
	public List<CardDetailsFromDB> cardStament(Long cardNo) throws SystemException, BusinessException;

	public List<CardInfo> allCardStament() throws BusinessException, SystemException;

	public void addCardInfo(CardInfo newCard) throws BusinessException;

	public List<CardInfo> allCardByCtype(String cType) throws BusinessException;

}
