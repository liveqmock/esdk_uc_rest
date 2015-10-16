package com.huawei.esdk.uc.north.rest.bean.ctc;

import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;

public class ReportTerminalTypeResBean
{
    private ResHeaderBean header;
    
    private ReportTerminalTypeResBody body;

    public ResHeaderBean getHeader()
    {
        return header;
    }

    public void setHeader(ResHeaderBean header)
    {
        this.header = header;
    }

    public ReportTerminalTypeResBody getBody()
    {
        return body;
    }

    public void setBody(ReportTerminalTypeResBody body)
    {
        this.body = body;
    }
}
