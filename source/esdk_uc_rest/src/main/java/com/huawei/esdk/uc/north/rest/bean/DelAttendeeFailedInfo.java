package com.huawei.esdk.uc.north.rest.bean;

public class DelAttendeeFailedInfo
{
    private String account;
    
    private String attNumber;
    
    private String failedReason;

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAttNumber()
    {
        return attNumber;
    }

    public void setAttNumber(String attNumber)
    {
        this.attNumber = attNumber;
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
