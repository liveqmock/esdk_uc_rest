package com.huawei.esdk.uc.north.rest.bean;

public class GatewayResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private GatewayList gatewayList;
    
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
    
    public GatewayList getGatewayList()
    {
        return gatewayList;
    }
    
    public void setGatewayList(GatewayList gatewayList)
    {
        this.gatewayList = gatewayList;
    }
    
}
