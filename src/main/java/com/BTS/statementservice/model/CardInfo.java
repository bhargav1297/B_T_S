package com.BTS.statementservice.model;

import jakarta.persistence.Column;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cardinfo")
@Data
public class CardInfo {

	@Id
	@Column(name = "card_no")
	private long cardNo;
	
	@Column(name = "avapoints")
	private int avaPoints;
	
	@Column(name = "ctype")
	private String cType;	
	
	@Column(name = "cvv")
	private int cvv;
	
	@Column(name = "cbank")
	private String cBank;	
	
	@Column(name = "cname")
	private String cName;
	
	@Column(name = "cust_name")
	private String custName;
	
	@Column(name = "exp_date")
	private String expDate;
	

	public CardInfo() {
		super();
		
	}

	public CardInfo(long cardNo, int avaPoints, String cType, int cvv, String cBank, String cName, String custName,
			String expDate) {
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
	
	

	@Override
	public String toString() {
		return "CardInfo [cardNo=" + cardNo + ", avaPoints=" + avaPoints + ", cType=" + cType + ", cvv=" + cvv
				+ ", cBank=" + cBank + ", cName=" + cName + ", custName=" + custName + ", expDate=" + expDate + "]";
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcBank() {
		return cBank;
	}

	public void setcBank(String cBank) {
		this.cBank = cBank;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}



	
}
