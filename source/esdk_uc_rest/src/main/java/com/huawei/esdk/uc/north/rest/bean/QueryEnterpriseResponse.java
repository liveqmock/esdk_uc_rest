package com.huawei.esdk.uc.north.rest.bean;

public class QueryEnterpriseResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private EnterpriseList enterpriseList;
    
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
    
    public EnterpriseList getEnterpriseList()
    {
        return enterpriseList;
    }
    
    public void setEnterpriseList(EnterpriseList enterpriseList)
    {
        this.enterpriseList = enterpriseList;
    }
    
}
