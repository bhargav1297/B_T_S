package com.BTS.statementservice.model;

import lombok.Data;

@Data
public class CardDetailsFromDB {

	
	private long cardNo;	
	private int avaPoints;
	private String cType;
	private int cvv;
	private String cBank;
	private String cName;
	private String custName;
	private String expDate;
	
	public CardDetailsFromDB(long cardNo, int avaPoints, String cType, int cvv, String cBank, String cName,
			String custName, String expDate) {
		super();
		this.cardNo = cardNo;
		this.avaPoints = avaPoints;
		this.cType = cType;
		this.cvv = cvv;
		this.cBank = cBank;
		this.cName = cName;
		this.custName = custName;
		this.expDate = expDate;
	}
	
	
	
		
	
	
	
	
	
	
	
}
