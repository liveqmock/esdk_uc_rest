package com.huawei.esdk.uc.north.rest.bean;

/**
 * @author sWX198756
 *
 */
public class UpdateAttendeeRequest
{
    /**
     * 账号
     */
    private String account;
    
    /**
     * 会议id
     */
    private String confId;
    
    /**
     * 会者号码
     */
    private String cee;
    
    /**
     * 话语权
     */
    private String auth;
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getCee()
    {
        return cee;
    }
    
    public void setCee(String cee)
    {
        this.cee = cee;
    }
    
    public String getAuth()
    {
        return auth;
    }
    
    public void setAuth(String auth)
    {
        this.auth = auth;
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
