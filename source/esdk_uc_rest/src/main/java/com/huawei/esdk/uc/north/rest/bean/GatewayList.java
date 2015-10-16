package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class GatewayList
{
    private int amount;
    
    private List<Gateway> gateways;

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public List<Gateway> getGateways()
    {
        return gateways;
    }

    public void setGateways(List<Gateway> gateways)
    {
        this.gateways = gateways;
    }
    
    
 }
