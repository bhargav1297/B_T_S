package com.BTS.statementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BTS.statementservice.dao.RewardsDaoImpl;
import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.exception.SystemException;
import com.BTS.statementservice.model.CardDetailsFromDB;
import com.BTS.statementservice.model.CardInfo;

@Component
public class StatementServiceImpl implements StatementService {

	@Autowired
	private RewardsDaoImpl rewardsDao;

	@Override
	public List<CardDetailsFromDB> cardStament(Long cardNo) throws SystemException, BusinessException {

		System.out.println("Entered into StatementServiceImpl2");

		List<CardDetailsFromDB> cardDetails = rewardsDao.fetchBycardNo(cardNo);
		
		System.out.println("Exit StatementServiceImpl2");

		return cardDetails;

	}

	@Override
	public List<CardInfo> allCardStament() throws  SystemException, BusinessException {
		System.out.println("Entered into StatementServiceImpl3");

		List<CardInfo> cardDetails = rewardsDao.fetchAll();

		System.out.println("Exit StatementServiceImpl3");

		return cardDetails;
	}

	@Override
	public void addCardInfo(CardInfo newCard) throws BusinessException {

		System.out.println("Entered into StatementServiceImpl1");
		rewardsDao.addCard(newCard);
		System.out.println("Exit StatementServiceImpl1");
		
	}

	@Override
	public List<CardInfo> allCardByCtype(String cType) throws BusinessException {
		System.out.println("Entered into StatementServiceImpl4");

		List<CardInfo> cardDetails = rewardsDao.fetchAllCardByType(cType);

		System.out.println("Exit StatementServiceImpl4");

		return cardDetails;
	}

}
