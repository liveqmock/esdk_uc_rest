package com.huawei.esdk.uc.north.rest.bean;

public class ModifyAccountPasswordRequest
{
    private String userId;
    
    private Account account;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public Account getAccount()
    {
        return account;
    }
    
    public void setAccount(Account account)
    {
        this.account = account;
    }
    
}
