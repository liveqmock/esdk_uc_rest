package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class BatchDelAccountRequest
{
    private String userId;
    
    private List<String> accountIds;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public List<String> getAccountIds()
    {
        return accountIds;
    }
    
    public void setAccountIds(List<String> accountIds)
    {
        this.accountIds = accountIds;
    }
    
}
