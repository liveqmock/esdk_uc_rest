package com.huawei.esdk.uc.north.rest.bean;

public class FailedAccount
{
    private String loginName;
    
    private String failedReason;
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
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
