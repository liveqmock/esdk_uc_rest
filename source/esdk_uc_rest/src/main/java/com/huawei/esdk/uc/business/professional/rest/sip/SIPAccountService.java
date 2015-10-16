package com.huawei.esdk.uc.business.professional.rest.sip;

import java.util.List;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.SIP;
import com.huawei.esdk.uc.domain.model.bean.GatewayList;
import com.huawei.esdk.uc.domain.model.bean.SIPCondition;
import com.huawei.esdk.uc.domain.model.bean.SIPList;

public class SIPAccountService
{
    
    public SDKErrorCode addSIP(String userId, SIP sip)
        throws SDKException
    {
        return sip.addSIP(userId, sip);
    }
    
    public SDKErrorCode modifySIP(String userId, SIP sip)
        throws SDKException
    {
        return sip.modifySIP(userId, sip);
    }
    
    public SDKErrorCode modifySipPassword(String userId, SIP sip)
        throws SDKException
    {
        return sip.modifySipPassword(userId, sip);
    }
    
    public SDKErrorCode deleteSip(String userId, SIP sip)
        throws SDKException
    {
        return sip.deleteSip(userId, sip);
    }
    
    public SDKResult<SIPList> batchDeleteSip(String userId, List<SIP> sips)
        throws SDKException
    {
        return new SIP().batchDeleteSip(userId, sips);
    }
    
    public SDKResult<SIPList> querySip(String userId, SIPCondition sipCon)
        throws SDKException
    {
        return new SIP().querySip(userId, sipCon);
    }

    public SDKResult<GatewayList> queryGateway(String userId)
        throws SDKException
    {
        return new SIP().queryGateway(userId);
    }

    public SDKErrorCode addSIPs(String userId, String numStep, String uestep, String amount, SIP sip) throws SDKException
    {
        return new SIP().addSIPs(userId, numStep, uestep, amount, sip);
    }
    
}
