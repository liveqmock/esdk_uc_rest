package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryPhoneStateResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private List<PhoneState> phoneStateList;

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

    public List<PhoneState> getPhoneStateList()
    {
        return phoneStateList;
    }

    public void setPhoneStateList(List<PhoneState> phoneStateList)
    {
        this.phoneStateList = phoneStateList;
    }
}
