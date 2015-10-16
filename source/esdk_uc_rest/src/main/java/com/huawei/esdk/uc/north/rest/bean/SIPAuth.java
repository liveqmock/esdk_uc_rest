package com.huawei.esdk.uc.north.rest.bean;

public class SIPAuth
{
    /**
     * 是否鉴权：0不鉴权，1密码鉴权，2IP鉴权，3密码和IP共同鉴权
     */
    private String type;
    
    /**
     * 鉴权密码
     */
    private String password;
    
    /**
     * 鉴权IP
     */
    private String ip;
    
    private String oldPassword;
    
    private String newPassword;
    
    private String oldIp;
    
    private String newIp;
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getOldPassword()
    {
        return oldPassword;
    }
    
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
    
    public String getNewPassword()
    {
        return newPassword;
    }
    
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
    public String getOldIp()
    {
        return oldIp;
    }
    
    public void setOldIp(String oldIp)
    {
        this.oldIp = oldIp;
    }
    
    public String getNewIp()
    {
        return newIp;
    }
    
    public void setNewIp(String newIp)
    {
        this.newIp = newIp;
    }
    
}
