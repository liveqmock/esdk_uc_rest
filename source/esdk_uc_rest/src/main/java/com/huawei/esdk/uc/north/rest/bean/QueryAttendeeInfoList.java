package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryAttendeeInfoList
{
    private String amount;
    
    private List<QueryAttendeeInfo> attendeeInfoList;

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public List<QueryAttendeeInfo> getAttendeeInfoList()
    {
        return attendeeInfoList;
    }

    public void setAttendeeInfoList(List<QueryAttendeeInfo> attendeeInfoList)
    {
        this.attendeeInfoList = attendeeInfoList;
    }
}
