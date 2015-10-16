package com.huawei.esdk.uc.north.rest.bean;

public class SIPAccountResponse
{
    /**
     * 统一网关IP
     */
    private String gwIp;
    
    /**
     * subpbx id
     */
    private String subPbx;
    
    /**
     * 本地网关ip
     */
    private String localGwIp;
    
    /**
     * 是否联动：0是否，1为是
     */
    private String joint;
    
    /**
     * SIP设备标识
     */
    private String sipUe;
    
    /**
     * 设备类型
     */
    private String ueType;
    
    /**
     * SIP号码
     */
    private String number;
    
    /**
     * 长号
     */
    private String longNum;
    
    /**
     * sip鉴权信息
     */
    private SIPAuthResponse sipAuth;
    
    /**
     * 权限级别
     */
    private String rightLevel;
    
    /**
     * 是否自动添加字冠：0为否，1为是
     */
    private String addPrefix;

    public String getGwIp()
    {
        return gwIp;
    }

    public void setGwIp(String gwIp)
    {
        this.gwIp = gwIp;
    }

    public String getSubPbx()
    {
        return subPbx;
    }

    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
    }

    public String getLocalGwIp()
    {
        return localGwIp;
    }

    public void setLocalGwIp(String localGwIp)
    {
        this.localGwIp = localGwIp;
    }

    public String getJoint()
    {
        return joint;
    }

    public void setJoint(String joint)
    {
        this.joint = joint;
    }

    public String getSipUe()
    {
        return sipUe;
    }

    public void setSipUe(String sipUe)
    {
        this.sipUe = sipUe;
    }

    public String getUeType()
    {
        return ueType;
    }

    public void setUeType(String ueType)
    {
        this.ueType = ueType;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getLongNum()
    {
        return longNum;
    }

    public void setLongNum(String longNum)
    {
        this.longNum = longNum;
    }

    public SIPAuthResponse getSipAuth()
    {
        return sipAuth;
    }

    public void setSipAuth(SIPAuthResponse sipAuth)
    {
        this.sipAuth = sipAuth;
    }

    public String getRightLevel()
    {
        return rightLevel;
    }

    public void setRightLevel(String rightLevel)
    {
        this.rightLevel = rightLevel;
    }

    public String getAddPrefix()
    {
        return addPrefix;
    }

    public void setAddPrefix(String addPrefix)
    {
        this.addPrefix = addPrefix;
    }
}
