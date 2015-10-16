package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryRoleInfoResponse
{
    private String amount;
    
    private List<RoleInfo> roleInfos;

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public List<RoleInfo> getRoleInfos()
    {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos)
    {
        this.roleInfos = roleInfos;
    }
}
