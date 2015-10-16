package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class DelAttendeeResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private List<DelAttendeeFailedInfo> attendeeFailedInfos;
    
    public List<DelAttendeeFailedInfo> getAttendeeFailedInfos()
    {
        return attendeeFailedInfos;
    }

    public void setAttendeeFailedInfos(List<DelAttendeeFailedInfo> attendeeFailedInfos)
    {
        this.attendeeFailedInfos = attendeeFailedInfos;
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
