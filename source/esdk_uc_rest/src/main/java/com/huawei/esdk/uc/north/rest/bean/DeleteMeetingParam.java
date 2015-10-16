package com.huawei.esdk.uc.north.rest.bean;

public class DeleteMeetingParam extends DeleteMeetingBaseParam
{
    //虚拟PBX ID，仅作为删除会议时的返回参数
    private String subPbx;

    public String getSubPbx()
    {
        return subPbx;
    }

    public void setSubPbx(String subPbx)
    {
        this.subPbx = subPbx;
    }
}
