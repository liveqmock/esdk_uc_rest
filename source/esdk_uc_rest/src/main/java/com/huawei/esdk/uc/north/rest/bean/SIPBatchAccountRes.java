package com.huawei.esdk.uc.north.rest.bean;

public class SIPBatchAccountRes
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
     * SIP号码
     */
    private String number;
    
    public String getNumber()
    {
        return number;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }

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
}
