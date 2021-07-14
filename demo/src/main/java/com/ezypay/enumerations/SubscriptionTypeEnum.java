package com.ezypay.enumerations;

public enum SubscriptionTypeEnum {
    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    MONTHLY("MONTHLY");

    private String code;
  
    SubscriptionTypeEnum(String code) {
        this.code = code;
     
    }
    public String getCode() {
        return code;
    }

    

}
