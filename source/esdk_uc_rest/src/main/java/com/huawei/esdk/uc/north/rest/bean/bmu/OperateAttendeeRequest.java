package com.huawei.esdk.uc.north.rest.bean.bmu;

import com.huawei.esdk.uc.domain.model.bean.Attendee;

public class OperateAttendeeRequest
{
    private String userId;
    
    private Attendee attendee;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public Attendee getAttendee()
    {
        return attendee;
    }
    
    public void setAttendee(Attendee attendee)
    {
        this.attendee = attendee;
    }
    
}
