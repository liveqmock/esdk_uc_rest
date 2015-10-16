package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryPhoneStateRequest
{
    private String userId;
    
    private List<PhoneInfo> phoneList;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public List<PhoneInfo> getPhoneList()
    {
        return phoneList;
    }

    public void setPhoneList(List<PhoneInfo> phoneList)
    {
        this.phoneList = phoneList;
    }
}
