package com.huawei.esdk.uc.north.rest.bean;

public class DepartmentInfo
{
    /**
     * 部门ID
     */
    private String deptId;
    
    /**
     * 部门名称
     */
    private String deptName;
    
    /**
     * 子部门的个数
     */
    private String subDeptCount;
    
    /**
     * 子部门中员工的数量
     */
    private String subEmployeeCount;
    
    public String getDeptId()
    {
        return deptId;
    }
    
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }
    
    public String getDeptName()
    {
        return deptName;
    }
    
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    
    public String getSubDeptCount()
    {
        return subDeptCount;
    }
    
    public void setSubDeptCount(String subDeptCount)
    {
        this.subDeptCount = subDeptCount;
    }
    
    public String getSubEmployeeCount()
    {
        return subEmployeeCount;
    }
    
    public void setSubEmployeeCount(String subEmployeeCount)
    {
        this.subEmployeeCount = subEmployeeCount;
    }
    
}
