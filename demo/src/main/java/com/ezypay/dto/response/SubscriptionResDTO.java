package com.ezypay.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SubscriptionResDTO implements Serializable {

    private static final long serialVersionUID = -90000041L;

    private BigDecimal amount;
    private String type;
    private ArrayList<String> invoiceDate;

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

    public ArrayList<String> getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(ArrayList<String> invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
