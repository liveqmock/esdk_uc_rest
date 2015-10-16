package com.huawei.esdk.uc.north.rest.bean;


public class SIPRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    private SIPAccount sip;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public SIPAccount getSip()
    {
        return sip;
    }
    
    public void setSip(SIPAccount sip)
    {
        this.sip = sip;
    }
    
}
