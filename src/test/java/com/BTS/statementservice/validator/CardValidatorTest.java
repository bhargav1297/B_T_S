package com.BTS.statementservice.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.BTS.statementservice.exception.CardStatementRequestInvalidException;

class CardValidatorTest {

	@Test
	void testCheckCardNull() {
		CardValidator card = new CardValidator();

		try {
			card.checkCard(null);
		} catch (CardStatementRequestInvalidException e) {

			assertEquals(e.getRespCode(), "enr001c");
		}

	}
	
	@Test
	void testCheckCardLength() {
		CardValidator card = new CardValidator();

		try {
			card.checkCard(90000000000L);
		} catch (CardStatementRequestInvalidException e) {

			assertEquals(e.getRespCode(), "enr002c");
		}

	}
	
	

}
