package com.huawei.esdk.uc.north.rest.bean.ctc;

import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;

public class QueryAttendenceResBean
{
    private ResHeaderBean header;
    
    private QueryAttendenceResBody body;

    public ResHeaderBean getHeader()
    {
        return header;
    }

    public void setHeader(ResHeaderBean header)
    {
        this.header = header;
    }

    public QueryAttendenceResBody getBody()
    {
        return body;
    }

    public void setBody(QueryAttendenceResBody body)
    {
        this.body = body;
    }
}
