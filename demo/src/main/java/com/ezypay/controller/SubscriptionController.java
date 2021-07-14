package com.ezypay.controller;


import com.ezypay.dto.request.SubscriptionReqDTO;
import com.ezypay.dto.response.SubscriptionResDTO;
import com.ezypay.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class SubscriptionController {

 

    @Autowired
    private SubscriptionService subscriptionService;

    
    @GetMapping("/greeting")
	public String greeting() {
		return ("Hello world");
	}
    
    @PostMapping(value = "add-subscription")
    public SubscriptionResDTO subscriptionController(@RequestBody SubscriptionReqDTO request) {
    	
        SubscriptionResDTO subscriptionRes = subscriptionService.addNewSubscription(request);
      
       
        return subscriptionRes;
    }
}
