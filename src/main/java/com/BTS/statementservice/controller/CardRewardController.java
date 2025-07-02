package com.BTS.statementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.exception.CardStatementRequestInvalidException;
import com.BTS.statementservice.exception.SystemException;
import com.BTS.statementservice.model.CardDetailsFromDB;
import com.BTS.statementservice.model.CardInfo;
import com.BTS.statementservice.service.StatementService;
import com.BTS.statementservice.validator.CardValidator;

@RestController
@RequestMapping("/reward")
@CrossOrigin(origins = "*")
public class CardRewardController {

//	@Autowired
	private StatementService service;

	@Autowired
	private CardValidator cValidate;
	
	@PostMapping("/addcard")
	public ResponseEntity<String> addCardDetails(@RequestBody CardInfo newCard) throws BusinessException{
		
		System.out.println(newCard.toString());
		System.out.println("Entered into CardRewardController1");
		// 1. call serviceImpl to Add card info
		service.addCardInfo(newCard);

		// 2. Send response to client
		System.out.println("Exit CardRewardController1");
		return ResponseEntity.ok("Card info added");

	}

	@GetMapping("/card/{cardNo}")
	public ResponseEntity<List<CardDetailsFromDB>> getCardRewardInfo(@PathVariable long cardNo)
			throws CardStatementRequestInvalidException// ResponseEntity<List<CardInfo>>
			, SystemException, BusinessException {
		System.out.println("Entered into CardRewardController2");

		// 1. Request validate
		cValidate.checkCard(cardNo);

		// 2. send the request to DAO and get the response
		List<CardDetailsFromDB> cardStament = service.cardStament(cardNo);

		// 3. Send response to client
		System.out.println("Exit CardRewardController2");
		return ResponseEntity.status(HttpStatus.FOUND).body(cardStament);

	}

	@GetMapping("/card")
	public ResponseEntity<List<CardInfo>> getAllReward() throws CardStatementRequestInvalidException// ResponseEntity<List<CardInfo>>
			, SystemException, BusinessException {
		System.out.println("Entered into CardRewardControlle3");

		// 1. send the request to DAO and get the response
		List<CardInfo> cardStament = service.allCardStament();

		// 2. Send response to client
		System.out.println("Exit CardRewardController3");
		return ResponseEntity.status(HttpStatus.FOUND).body(cardStament);

	}
	
	@GetMapping("/ctype/{cType}")
	public ResponseEntity<List<CardInfo>> getAllCtype(@PathVariable String cType) throws BusinessException
	{
		System.out.println("Entered into CardRewardControlle4");

		// 1. send the request to DAO and get the response
		List<CardInfo> cards = service.allCardByCtype(cType);

		// 2. Send response to client
		System.out.println("Exit CardRewardController4");
		
		return ResponseEntity.status(HttpStatus.FOUND).body(cards);
		
	}

	public CardRewardController(StatementService service) {
		super();
		this.service = service;
	}

	
}
