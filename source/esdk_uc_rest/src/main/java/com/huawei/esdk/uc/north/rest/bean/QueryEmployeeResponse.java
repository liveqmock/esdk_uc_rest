package com.huawei.esdk.uc.north.rest.bean;

public class QueryEmployeeResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private EmployeeList employeeList;
    
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
    
    public EmployeeList getEmployeeList()
    {
        return employeeList;
    }
    
    public void setEmployeeList(EmployeeList employeeList)
    {
        this.employeeList = employeeList;
    }
    
}
