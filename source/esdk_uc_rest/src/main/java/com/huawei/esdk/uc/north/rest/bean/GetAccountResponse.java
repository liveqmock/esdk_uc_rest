package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class GetAccountResponse
{
    private int amount;
    
    private List<AccountResponse> accounts;
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    public List<AccountResponse> getAccounts()
    {
        return accounts;
    }
    
    public void setAccounts(List<AccountResponse> accounts)
    {
        this.accounts = accounts;
    }
    
}
