package com.huawei.esdk.uc.north.rest.bean;

public class QueryAttendeeResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private QueryAttendeeInfoList queryAttendeeInfoList;

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

    public QueryAttendeeInfoList getQueryAttendeeInfoList()
    {
        return queryAttendeeInfoList;
    }

    public void setQueryAttendeeInfoList(QueryAttendeeInfoList queryAttendeeInfoList)
    {
        this.queryAttendeeInfoList = queryAttendeeInfoList;
    }
}
