package com.ezypay.service;

import com.ezypay.dto.request.SubscriptionReqDTO;
import com.ezypay.dto.response.SubscriptionResDTO;
import com.ezypay.enumerations.DayOfWeeksEnum;
import com.ezypay.enumerations.SubscriptionTypeEnum;
import com.ezypay.service.helper.ReqValidation;
import com.ezypay.util.DateManageFunction;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class SubscriptionService {


	 
    public SubscriptionResDTO addNewSubscription(SubscriptionReqDTO request){
    	 SubscriptionResDTO response = new SubscriptionResDTO();
    	try {
    		ReqValidation.validateSubscriptionRequest(request);
		        response.setAmount(request.getAmount());
		        response.setType(request.getType());
		        if (SubscriptionTypeEnum.WEEKLY.getCode().equals(request.getType())) {
		            Date startDate = DateManageFunction.nextDateOfWeek(request.getStartDate(), DayOfWeeksEnum.getDayOfWeek(request.getDayOfWeekMonth()));
		            response.setInvoiceDate(getInvoiceDateList(startDate,request.getEndDate(),7));
		            
		        } else if (SubscriptionTypeEnum.MONTHLY.getCode().equals(request.getType())) {
		            Date startDate = DateManageFunction.nextDateOfMonth(request.getStartDate(),Integer.parseInt(request.getDayOfWeekMonth()));
		            response.setInvoiceDate(getInvoiceDateList(startDate,request.getEndDate(),30));
		            
		        } else if (SubscriptionTypeEnum.DAILY.getCode().equals(request.getType())) {
		            response.setInvoiceDate(getInvoiceDateList(request.getStartDate(),request.getEndDate(),1));
		            
		        }
 
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return response;
       
    }
    

    private ArrayList<String> getInvoiceDateList(Date startDate,Date endDate,int numberOfDays){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        ArrayList<String> invoiceDate = new ArrayList<>();
        invoiceDate.add(dateFormat.format(startDate));
        Date nextSubDate = startDate;
        while (true) {
             nextSubDate = DateManageFunction.addDate(nextSubDate, 0, 0, numberOfDays);
            if (nextSubDate.compareTo(endDate) < 0) {

                invoiceDate.add(dateFormat.format(nextSubDate));
            } else {
                break;
            }
        }
        return invoiceDate;
    }
}
