package com.huawei.esdk.uc.north.rest.bean.ctc;

import java.util.List;

public class QueryAttendenceResBody
{
    private String num;
    
    private List<Attendee> attendences;

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public List<Attendee> getAttendences()
    {
        return attendences;
    }

    public void setAttendences(List<Attendee> attendences)
    {
        this.attendences = attendences;
    }
}
