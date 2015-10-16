package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

/**
 * @author sWX198756
 *
 */
public class ConferenceInfo
{
    /**
     * 用户账号
     */
    private String account;
    
    /**
     * 会议id
     */
    private String confId;
    
    /**
     * 会议主题
     */
    private String topic;
    
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
    
    /**
     * 与会人号码
     */
    private List<Invitee> invitees;
    
    public String getTopic()
    {
        return topic;
    }
    
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    public List<Invitee> getInvitees()
    {
        return invitees;
    }
    
    public void setInvitees(List<Invitee> invitees)
    {
        this.invitees = invitees;
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
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
}
