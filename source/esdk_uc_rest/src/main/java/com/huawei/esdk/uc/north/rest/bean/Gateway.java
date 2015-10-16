package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class Gateway
{
    private String gwIp;
    
    private List<String> subPbxs;
    
    private String state;
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public List<String> getSubPbxs()
    {
        return subPbxs;
    }

    public void setSubPbxs(List<String> subPbxs)
    {
        this.subPbxs = subPbxs;
    }
    
}
