package com.huawei.esdk.uc.north.rest.bean;

public class QueryDepartmentResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private QueryDepartmentInfoList queryDepartmentInfoList;
    
    public QueryDepartmentInfoList getQueryDepartmentInfoList()
    {
        return queryDepartmentInfoList;
    }
    
    public void setQueryDepartmentInfoList(QueryDepartmentInfoList queryDepartmentInfoList)
    {
        this.queryDepartmentInfoList = queryDepartmentInfoList;
    }
    
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
}
