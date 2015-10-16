package com.huawei.esdk.uc.north.rest.bean;

public class AddDepartmentResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private String departmentId;
    
    private String departmentNo;
    
    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentNo()
    {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo)
    {
        this.departmentNo = departmentNo;
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
