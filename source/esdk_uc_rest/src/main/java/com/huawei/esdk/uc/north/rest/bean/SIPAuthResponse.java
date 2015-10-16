package com.huawei.esdk.uc.north.rest.bean;

public class SIPAuthResponse
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
}
