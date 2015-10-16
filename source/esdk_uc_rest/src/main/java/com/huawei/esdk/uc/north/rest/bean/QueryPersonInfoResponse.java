package com.huawei.esdk.uc.north.rest.bean;

public class QueryPersonInfoResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private PersonInfo personInfo;
    
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
    
    public PersonInfo getPersonInfo()
    {
        return personInfo;
    }
    
    public void setPersonInfo(PersonInfo personInfo)
    {
        this.personInfo = personInfo;
    }
    
}
