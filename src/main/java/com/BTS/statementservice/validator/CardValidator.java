package com.BTS.statementservice.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.BTS.statementservice.exception.CardStatementRequestInvalidException;

@Component
public class CardValidator  {
	
	public void checkCard(Long cardNumb) throws CardStatementRequestInvalidException
	{
		System.out.println("Enterd CardValidation");
		if(cardNumb==null)
		{
//			System.out.println("card is null"); 
			throw new CardStatementRequestInvalidException("enr001c", "Card info is Null");
		}
		if(cardNumb.toString().length()<12 || cardNumb.toString().length()>12)
		{
			throw new CardStatementRequestInvalidException("enr002c", "check Card lenght");
		}
		if(cardNumb.toString().isBlank())
		{
//			System.out.println("card has white space"); 
			throw new CardStatementRequestInvalidException("enr003c", "card has white space");
		}
		
		//*************TODO***************
		//Implement if card is numeric
		
		System.out.println("Exit CardValidation");
	}

}
