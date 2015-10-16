package com.huawei.esdk.uc.north.rest.bean;

public class SIPQueryResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private SIPList sipList;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultContext()
    {
        return resultContext;
    }
    
    public void setResultContext(String resultContext)
    {
        this.resultContext = resultContext;
    }
    
    public SIPList getSipList()
    {
        return sipList;
    }
    
    public void setSipList(SIPList sipList)
    {
        this.sipList = sipList;
    }
    
}
