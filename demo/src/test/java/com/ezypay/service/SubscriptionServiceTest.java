package com.ezypay.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import com.ezypay.enumerations.DayOfWeeksEnum;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezypay.dto.request.SubscriptionReqDTO;
import com.ezypay.dto.response.SubscriptionResDTO;
import com.ezypay.enumerations.SubscriptionTypeEnum;

@SpringBootTest
class SubscriptionServiceTest {

	@InjectMocks
	private SubscriptionService subscriptionService = Mockito.spy(new SubscriptionService());


	@Before
	public void initializeMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addNewSubscription_NullSubscriptionReqDTO_SuccessDaily() {
		SubscriptionReqDTO SubscriptionReqDTO = new SubscriptionReqDTO();
		SubscriptionReqDTO.setStartDate(new Date());
		SubscriptionReqDTO.setEndDate(new Date());
		SubscriptionReqDTO.setAmount(new BigDecimal(10));
		SubscriptionReqDTO.setType(SubscriptionTypeEnum.DAILY.getCode());
		SubscriptionResDTO response = subscriptionService.addNewSubscription(SubscriptionReqDTO);

		System.out.println("Daily");	
		System.out.println("Amount : " + response.getAmount());
		System.out.println("Type : " + response.getType());
		System.out.println("Date : " + response.getInvoiceDate());
		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.DAILY.getCode(), response.getType());
	}

	@Test
	public void addNewSubscription_NullSubscriptionReqDTO_SuccessWeekly() {
		SubscriptionReqDTO SubscriptionReqDTO = new SubscriptionReqDTO();
		SubscriptionReqDTO.setStartDate(new Date());
		SubscriptionReqDTO.setEndDate(new Date());
		SubscriptionReqDTO.setAmount(new BigDecimal(30));
		SubscriptionReqDTO.setType(SubscriptionTypeEnum.WEEKLY.getCode());
		SubscriptionReqDTO.setDayOfWeekMonth(DayOfWeeksEnum.MONDAY.getCode());
		SubscriptionResDTO response = subscriptionService.addNewSubscription(SubscriptionReqDTO);
		
		System.out.println("Weekly");	
		System.out.println("Amount : " + response.getAmount());
		System.out.println("Type : " + response.getType());
		System.out.println("Date : " + response.getInvoiceDate());
		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.WEEKLY.getCode(), response.getType());
	}

	@Test
	public void addNewSubscription_NullSubscriptionReqDTO_SuccessMonthly() {
		SubscriptionReqDTO SubscriptionReqDTO = new SubscriptionReqDTO();
		SubscriptionReqDTO.setStartDate(new Date());
		SubscriptionReqDTO.setEndDate(new Date());
		SubscriptionReqDTO.setAmount(new BigDecimal(60));
		SubscriptionReqDTO.setType(SubscriptionTypeEnum.MONTHLY.getCode());
		SubscriptionReqDTO.setDayOfWeekMonth("20");
		SubscriptionResDTO response = subscriptionService.addNewSubscription(SubscriptionReqDTO);
		System.out.println("Monthly");	
		System.out.println("Amount : " + response.getAmount());
		System.out.println("Type : " + response.getType());
		System.out.println("Date : " + response.getInvoiceDate());
		assertNotNull(response);
		assertEquals(SubscriptionTypeEnum.MONTHLY.getCode(), response.getType());
	}
}
