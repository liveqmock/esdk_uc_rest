package com.huawei.esdk.uc.business.professional.rest.conf;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.Conference;
import com.huawei.esdk.uc.domain.model.bean.ConfPrefixList;
import com.huawei.esdk.uc.domain.model.bean.GlobalSRTPList;

public class ConfService
{
    
    public SDKResult<GlobalSRTPList> queryGlobalSRTP(String userId, String gwip, String pageNum, String pageCount)
        throws SDKException
    {
        return new Conference().queryGlobalSRTP(userId, gwip, pageNum, pageCount);
    }
    
    public SDKResult<ConfPrefixList> queryConfPrefix(String userId, String gwip)
        throws SDKException
    {
        return new Conference().queryConfPrefix(userId, gwip);
    }
}
