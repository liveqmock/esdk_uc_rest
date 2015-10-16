package com.huawei.esdk.uc.north.rest.bean;


/**
 * @author sWX198756
 *
 */
public class QueryConferenceInfo
{
    
    /**
     * 会议id
     */
    private String confId;
    
    /**
     * 会议主题
     */
    private String subject;
    
    /**
     * 会议开始时间
     */
    private String startTime;
    
    /**
     * 会议主持人
     */
    private String emcee;
    
    /**
     * 会议状态
     */
    private String status;
    
    
    public String getSubject()
    {
        return subject;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    public String getEmcee()
    {
        return emcee;
    }
    
    public void setEmcee(String emcee)
    {
        this.emcee = emcee;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    
}
