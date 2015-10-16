package com.huawei.esdk.uc.business.professional.rest.role;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.Role;

public class RoleService
{
    
    public SDKResult<Role> queryRole(String userId, String pageCount, String pageNum, String lang)
        throws SDKException
    {
        return new Role().queryRole(userId, pageCount, pageNum, lang);
    }
    
}
