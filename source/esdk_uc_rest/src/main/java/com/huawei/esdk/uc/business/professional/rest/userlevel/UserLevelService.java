package com.huawei.esdk.uc.business.professional.rest.userlevel;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.UserLevel;

public class UserLevelService
{

    public SDKResult<UserLevel> queryUserLevel(String userId, String pageCount, 
        String pageNum) throws SDKException
    {
        return new UserLevel().queryUserLevel(userId, pageCount, pageNum);
    }
    
}
