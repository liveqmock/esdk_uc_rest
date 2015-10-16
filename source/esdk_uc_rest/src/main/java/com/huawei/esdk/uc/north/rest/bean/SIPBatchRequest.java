package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class SIPBatchRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    private List<SIPAccount> sips;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public List<SIPAccount> getSips()
    {
        return sips;
    }
    
    public void setSips(List<SIPAccount> sips)
    {
        this.sips = sips;
    }
    
}
