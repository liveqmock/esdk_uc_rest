package com.huawei.esdk.uc.north.rest.bean;

public class SIPBatchAddRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    //号码步长
    private String numStep;
    
    //号码总数，不能超过1000
    private String amount;
    
    //设备步长
    private String ueStep;
    
    //初始号码
    private SIPAccount sip;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getNumStep()
    {
        return numStep;
    }

    public void setNumStep(String numStep)
    {
        this.numStep = numStep;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getUeStep()
    {
        return ueStep;
    }

    public void setUeStep(String ueStep)
    {
        this.ueStep = ueStep;
    }

    public SIPAccount getSip()
    {
        return sip;
    }

    public void setSip(SIPAccount sip)
    {
        this.sip = sip;
    }

}
