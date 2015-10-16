package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class SIPList
{
    private String amount;
    
    private List<SIPAccountResponse> sips;
    
    public String getAmount()
    {
        return amount;
    }
    
    public void setAmount(String amount)
    {
        this.amount = amount;
    }
    
    public List<SIPAccountResponse> getSips()
    {
        return sips;
    }
    
    public void setSips(List<SIPAccountResponse> sips)
    {
        this.sips = sips;
    }
    
}
