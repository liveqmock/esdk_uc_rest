package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryDepartmentInfoList
{
    private String amount;
    
    private List<QueryDepartmentInfo> departmentInfoList;

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public List<QueryDepartmentInfo> getDepartmentInfoList()
    {
        return departmentInfoList;
    }

    public void setDepartmentInfoList(List<QueryDepartmentInfo> departmentInfoList)
    {
        this.departmentInfoList = departmentInfoList;
    }
}
