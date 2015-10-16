package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryUserLevelResponse
{
    private String amount;
    
    private List<UserLevelInfo> userLevelInfos;

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public List<UserLevelInfo> getUserLevelInfos()
    {
        return userLevelInfos;
    }

    public void setUserLevelInfos(List<UserLevelInfo> userLevelInfos)
    {
        this.userLevelInfos = userLevelInfos;
    }
    
    
}
