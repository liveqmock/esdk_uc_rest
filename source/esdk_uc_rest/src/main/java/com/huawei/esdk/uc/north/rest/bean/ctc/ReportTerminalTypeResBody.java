package com.huawei.esdk.uc.north.rest.bean.ctc;

import java.util.Date;

public class ReportTerminalTypeResBody
{
    private String confId;
    
    private String confType;
    
    private String dataConfUrl;
    
    private String siteId;
    
    private String hostKey;
    
    private String attendeeNum;
    
    private String attendeeType;
    
    private String token;
    
    private Date timeStamp;
    
    private String msAddr;

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }

    public String getConfType()
    {
        return confType;
    }

    public void setConfType(String confType)
    {
        this.confType = confType;
    }

    public String getDataConfUrl()
    {
        return dataConfUrl;
    }

    public void setDataConfUrl(String dataConfUrl)
    {
        this.dataConfUrl = dataConfUrl;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public String getHostKey()
    {
        return hostKey;
    }

    public void setHostKey(String hostKey)
    {
        this.hostKey = hostKey;
    }

    public String getAttendeeNum()
    {
        return attendeeNum;
    }

    public void setAttendeeNum(String attendeeNum)
    {
        this.attendeeNum = attendeeNum;
    }

    public String getAttendeeType()
    {
        return attendeeType;
    }

    public void setAttendeeType(String attendeeType)
    {
        this.attendeeType = attendeeType;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public Date getTimeStamp()
    {
        if(timeStamp == null)
            return null;
        return (Date)timeStamp.clone();
    }

    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = (Date)timeStamp.clone();
    }

    public String getMsAddr()
    {
        return msAddr;
    }

    public void setMsAddr(String msAddr)
    {
        this.msAddr = msAddr;
    }

}
