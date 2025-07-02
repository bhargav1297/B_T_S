package com.BTS.statementservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.BTS.statementservice.exception.BusinessException;
import com.BTS.statementservice.model.CardInfo;
import com.BTS.statementservice.service.StatementService;

@ExtendWith(MockitoExtension.class)
class CardRewardControllerTest2 {
	
	@Mock
    private StatementService mockService;
	
	@InjectMocks
    private CardRewardController controller;

    @Test
    void testAddCardDetails_Visa() throws BusinessException {
//        StatementService mockService = Mockito.mock(StatementService.class); --line25

        when(mockService.allCardByCtype(any())).thenReturn(buildServiceRespforCtype());

        controller = new CardRewardController(mockService);
        ResponseEntity<List<CardInfo>> cardDetails = null;

        try {
            cardDetails = controller.getAllCtype("VISA");
//            System.out.println(cardDetails);
            assertEquals(3, cardDetails.getBody().size());
        } catch (BusinessException e) {
            assertEquals("101", e.getRespCode());
        }
    }

    private List<CardInfo> buildServiceRespforCtype() {
        CardInfo c1 = new CardInfo();
        CardInfo c2 = new CardInfo();
        CardInfo c3 = new CardInfo();

        List<CardInfo> allCard = new ArrayList<>();
        allCard.add(c1);
        allCard.add(c2);
        allCard.add(c3);

        return allCard;
    }
}
