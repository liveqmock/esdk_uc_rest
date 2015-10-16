package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class BatchAddAccountResponse
{
    private String successAmount;
    
    private String failedAmount;
    
    private List<String> accountIds;
    
    private List<FailedAccount> failedAccounts;
    
    public String getSuccessAmount()
    {
        return successAmount;
    }
    
    public void setSuccessAmount(String successAmount)
    {
        this.successAmount = successAmount;
    }
    
    public String getFailedAmount()
    {
        return failedAmount;
    }
    
    public void setFailedAmount(String failedAmount)
    {
        this.failedAmount = failedAmount;
    }
    
    public List<String> getAccountIds()
    {
        return accountIds;
    }
    
    public void setAccountIds(List<String> accountIds)
    {
        this.accountIds = accountIds;
    }
    
    public List<FailedAccount> getFailedAccounts()
    {
        return failedAccounts;
    }
    
    public void setFailedAccounts(List<FailedAccount> failedAccounts)
    {
        this.failedAccounts = failedAccounts;
    }
    
}
