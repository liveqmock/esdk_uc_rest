package com.huawei.esdk.uc.north.rest.bean;

public class DeleteMeetingBaseParam
{
    //网关IP
    private String gwIp;
    
    //会议厅号
    private String confId;

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confNo)
    {
        this.confId = confNo;
    }
}
