package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class BatchDelAccountResponse
{
    private String failedAmount;
    
    private List<FailedDelAccount> failedAccounts;
    
    public String getFailedAmount()
    {
        return failedAmount;
    }
    
    public void setFailedAmount(String failedAmount)
    {
        this.failedAmount = failedAmount;
    }
    
    public List<FailedDelAccount> getFailedAccounts()
    {
        return failedAccounts;
    }
    
    public void setFailedAccounts(List<FailedDelAccount> failedAccounts)
    {
        this.failedAccounts = failedAccounts;
    }
    
}
