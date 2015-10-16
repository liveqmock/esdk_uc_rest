package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class AfficheRequest
{
    private String initiatorId;
    
    /**
     * 公告主题
     */
    private String afficheTitle;
    
    /**
     * 公告内容
     */
    private String afficheContent;
    
    /**
     * 0代表部门发送，1代表按用户发送
     */
    private String receiverType;
    
    /**
     * espace号码
     */
    private List<String> staffAccounts;
    
    /**
     * 部门ID。-1表示根部门
     */
    private List<String> departmentIds;
    
    public String getAfficheTitle()
    {
        return afficheTitle;
    }
    
    public void setAfficheTitle(String afficheTitle)
    {
        this.afficheTitle = afficheTitle;
    }
    
    public String getAfficheContent()
    {
        return afficheContent;
    }
    
    public void setAfficheContent(String afficheContent)
    {
        this.afficheContent = afficheContent;
    }
    
    public String getReceiverType()
    {
        return receiverType;
    }
    
    public void setReceiverType(String receiverType)
    {
        this.receiverType = receiverType;
    }
    
    public List<String> getStaffAccounts()
    {
        return staffAccounts;
    }
    
    public void setStaffAccounts(List<String> staffAccounts)
    {
        this.staffAccounts = staffAccounts;
    }
    
    public List<String> getDepartmentIds()
    {
        return departmentIds;
    }
    
    public void setDepartmentIds(List<String> departmentIds)
    {
        this.departmentIds = departmentIds;
    }
    
    public String getInitiatorId()
    {
        return initiatorId;
    }
    
    public void setInitiatorId(String initiatorId)
    {
        this.initiatorId = initiatorId;
    }
    
}
