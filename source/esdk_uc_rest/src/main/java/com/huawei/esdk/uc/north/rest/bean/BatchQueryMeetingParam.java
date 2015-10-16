package com.huawei.esdk.uc.north.rest.bean;

public class BatchQueryMeetingParam
{
    //操作用户
    private String userId;
    
    //会议Id
    private String confId;
    
    //与会人号码
    private String phone;
    
    //会议主题 
    private String confName;
    
    //起始时间
    private String startTime;
    
    //结束时间
    private String endTime;
    
    //分页大小
    private String pageCount;
    
    //分页
    private String pageNum;

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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getConfName()
    {
        return confName;
    }

    public void setConfName(String confName)
    {
        this.confName = confName;
    }

    public String getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(String pageCount)
    {
        this.pageCount = pageCount;
    }

    public String getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
}
