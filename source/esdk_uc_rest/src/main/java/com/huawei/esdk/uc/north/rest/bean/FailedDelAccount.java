package com.huawei.esdk.uc.north.rest.bean;

public class FailedDelAccount
{
    private String accountId;
    
    private String failedReason;
    
    public String getAccountId()
    {
        return accountId;
    }
    
    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
    public String getFailedReason()
    {
        return failedReason;
    }
    
    public void setFailedReason(String failedReason)
    {
        this.failedReason = failedReason;
    }
    
}
