package com.huawei.esdk.uc.north.rest.bean;

/**
 * 部门模块请求入参
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK UC V100R003C30
 */
public class DepartmentRequest
{
    private String userId;
    
    private String parentId;
    
    private String departmentId;
    
    private String departmentName;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
}
