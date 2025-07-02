package com.BTS.statementservice.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.exception.SystemException;
import com.BTS.statementservice.model.CardDetailsFromDB;
import com.BTS.statementservice.model.CardInfo;
import com.BTS.statementservice.model.CardInfoRepositry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Component
public class RewardsDaoImpl {

	@Autowired
	private CardInfoRepositry repositry;

	@PersistenceContext
	private EntityManager entityManager;

	public List<CardDetailsFromDB> fetchBycardNo(Long cardNo) throws BusinessException, SystemException {

		List<CardDetailsFromDB> resultList = new ArrayList<>();// null;//=(
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GETREWARDS_INFO");
		String dbRespCode = "";
		String dbRespMsg = "";

		System.out.println("Entered into RewardsDaoImpl1");

		try {

			// Registering Inputs
			query.registerStoredProcedureParameter("CARDNUM_IN", BigInteger.class, ParameterMode.IN);
			query.setParameter("CARDNUM_IN", cardNo);

			// Registering Outputs
			query.registerStoredProcedureParameter("RESP_CODE_OUT", String.class, ParameterMode.OUT);
			query.registerStoredProcedureParameter("RESP_MSG_OUT", String.class, ParameterMode.OUT);

			// Execute procedure
			boolean hasResult = query.execute();

			dbRespMsg = (String) query.getOutputParameterValue("RESP_MSG_OUT");
			dbRespCode = (String) query.getOutputParameterValue("RESP_CODE_OUT");

//			System.out.println(hasResult + "-------" + dbRespCode + "------" + dbRespMsg);

			if (hasResult) {
				List<Object[]> rows = query.getResultList();
				
				Object rows1=query.getResultList();
				
				
				System.out.println("Entered into if"+rows1.toString());

				for (Object[] row : rows) {
					long cNo = (long) row[0];
					int avaPoints = (int) row[1];
					String cType = (String) row[2];
					int cvv = (int) row[3];
					String cBank = (String) row[4];
					String cName = (String) row[5];
					String custName = (String) row[6];
					String expDate = (String) row[7];
					resultList.add(new CardDetailsFromDB(cNo, avaPoints, cType, cvv, cBank, cName, custName, expDate));
				}
			}
			if (resultList != null && "0".equals(dbRespCode)) {
				System.out.println("Card is valid");
			} else if ("101".equals(dbRespCode) || "102".equals(dbRespCode)) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else if ("333".equals(dbRespCode) || "444".equals(dbRespCode)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			} else {
				throw new SystemException("888", "Unknow response from DB");
			}
		} catch (BusinessException be) {
			throw be;
		} catch (SystemException se) {
			throw se;
		}

		return resultList;

	}

	public List<CardInfo> fetchAll() throws BusinessException, SystemException {
		List<CardInfo> cardDetails;

		try {
			String dbRespCode = "0";
			String dbRespMsg = "success";

			cardDetails = repositry.findAll();
			if (!cardDetails.isEmpty() && "0".equals(dbRespCode)) {
				System.out.println("Card detail available\n");

			} else if ("101".equals(dbRespCode) || "102".equals(dbRespCode)) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else if ("333".equals(dbRespCode) || "444".equals(dbRespCode)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			} else {
				throw new SystemException("888", "Unknow response from DB");
			}
		} catch (BusinessException be) {
			throw be;
		} catch (SystemException se) {
			throw se;
		}

		return cardDetails;
	}

	
	public void addCard(CardInfo newCard) throws BusinessException {
		
		Optional<CardInfo> cardById = repositry.findById(newCard.getCardNo());
		
		if(cardById.isEmpty())
		{
			CardInfo savedCard = repositry.save(newCard);
			System.out.println(savedCard.getCardNo()+" saved");
		}		 
		 else { 
			 throw new BusinessException("103","card Not saved|| Duplicate card"); }
		
	}

	public List<CardInfo> fetchAllCardByType(String cType) throws BusinessException {
		List<CardInfo> fetchByCtype = repositry.fetchByCtpe(cType);
		
		if(!fetchByCtype.isEmpty())
		{
			System.out.println(fetchByCtype.size()+" Card details are available with cType: "+cType);
		}
		else
		{
			throw new BusinessException("101", "Invalid Card Type|| No data");
		}
		return fetchByCtype;
	}

}
