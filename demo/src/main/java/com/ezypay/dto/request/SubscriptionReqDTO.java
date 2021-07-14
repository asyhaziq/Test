package com.ezypay.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionReqDTO implements Serializable {

    private static final long serialVersionUID = -90000021L;

    private BigDecimal amount;
    private String type;
    private String dayOfWeekMonth;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date startDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date endDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDayOfWeekMonth() {
        return dayOfWeekMonth;
    }

    public void setDayOfWeekMonth(String dayOfWeekMonth) {
        this.dayOfWeekMonth = dayOfWeekMonth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
