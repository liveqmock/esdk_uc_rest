package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class SIPBatchList
{
    private String amount;
    
    private List<SIPBatchAccountRes> sips;
    
    public String getAmount()
    {
        return amount;
    }
    
    public void setAmount(String amount)
    {
        this.amount = amount;
    }
    
    public List<SIPBatchAccountRes> getSips()
    {
        return sips;
    }
    
    public void setSips(List<SIPBatchAccountRes> sips)
    {
        this.sips = sips;
    }
    
}
