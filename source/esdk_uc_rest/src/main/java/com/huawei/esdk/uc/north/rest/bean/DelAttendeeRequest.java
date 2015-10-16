package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class DelAttendeeRequest
{
    private String userId;
    
    private String gwIp;
    
    //private String confNo;
    
    private String confId;
    
    private List<DelAttendeeInfo> attendeeInfos;
    
    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

//    public String getConfNo()
//    {
//        return confNo;
//    }
//
//    public void setConfNo(String confNo)
//    {
//        this.confNo = confNo;
//    }

    public List<DelAttendeeInfo> getAttendeeInfos()
    {
        return attendeeInfos;
    }

    public void setAttendeeInfos(List<DelAttendeeInfo> attendeeInfos)
    {
        this.attendeeInfos = attendeeInfos;
    }

    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
}
