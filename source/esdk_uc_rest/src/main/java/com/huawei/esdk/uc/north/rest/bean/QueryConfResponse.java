package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class QueryConfResponse
{
    private String resultCode;
    
    private String resultContext;
    
    /**
     * CTC会议列表
     */
    private List<QueryConferenceInfo> confs;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultContext()
    {
        return resultContext;
    }
    
    public void setResultContext(String resultContext)
    {
        this.resultContext = resultContext;
    }

    public List<QueryConferenceInfo> getConfs()
    {
        return confs;
    }

    public void setConfs(List<QueryConferenceInfo> confs)
    {
        this.confs = confs;
    }

}
