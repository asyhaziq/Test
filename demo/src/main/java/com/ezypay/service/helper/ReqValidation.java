package com.ezypay.service.helper;

import com.ezypay.dto.request.SubscriptionReqDTO;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import com.ezypay.util.DateManageFunction;
import org.springframework.stereotype.Service;

@Service
public class ReqValidation {

    public static void validateSubscriptionRequest(SubscriptionReqDTO request) throws Exception  {
    	System.out.println("masuk");
        if (request.getAmount() == null) {
        	throw new Exception("Please enter subscription amount ");
        }
        if (request.getType().isEmpty()) {
        	throw new Exception("Please enter subscription type ");
        }
        if ((SubscriptionTypeEnum.WEEKLY.getCode().equals(request.getType()) || SubscriptionTypeEnum.MONTHLY.getCode().equals(request.getType())) && request.getDayOfWeekMonth().isEmpty()) {
        	throw new Exception("Please enter Subscription Date Month ");
        }
        if (request.getStartDate() == null || request.getEndDate() == null) {
        	throw new Exception("Please enter subscription Start / End Date ");
        }
        if (DateManageFunction.isDateAfter(request.getStartDate(), request.getEndDate(), 3)) {
        	throw new Exception("Invalid subscription period ");
        }

   
    }
}
