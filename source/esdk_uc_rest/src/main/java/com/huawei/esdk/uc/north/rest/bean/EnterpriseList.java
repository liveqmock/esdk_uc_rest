package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class EnterpriseList
{
    
    /**
     * 某层级部门中部门和员工的总数
     */
    private String total;
    
    /**
     * 当前分页中部门的数量
     */
    private String deptSum;
    
    /**
     * 当前分页中员工的数量
     */
    private String employeeSum;
    
    /**
     * 上一级部门ID
     */
    private String parentDept;
    
    /**
     * 个人信息
     */
    private List<DepartmentInfo> departments;
    
    /**
     * 个人信息
     */
    private List<PersonInfo> employees;
    
    public String getTotal()
    {
        return total;
    }
    
    public void setTotal(String total)
    {
        this.total = total;
    }
    
    public String getDeptSum()
    {
        return deptSum;
    }
    
    public void setDeptSum(String deptSum)
    {
        this.deptSum = deptSum;
    }
    
    public String getEmployeeSum()
    {
        return employeeSum;
    }
    
    public void setEmployeeSum(String employeeSum)
    {
        this.employeeSum = employeeSum;
    }
    
    public String getParentDept()
    {
        return parentDept;
    }
    
    public void setParentDept(String parentDept)
    {
        this.parentDept = parentDept;
    }
    
    public List<PersonInfo> getEmployees()
    {
        return employees;
    }
    
    public void setEmployees(List<PersonInfo> employees)
    {
        this.employees = employees;
    }
    
    public List<DepartmentInfo> getDepartments()
    {
        return departments;
    }
    
    public void setDepartments(List<DepartmentInfo> departments)
    {
        this.departments = departments;
    }
    
}
