package com.huawei.esdk.uc.business.professional.rest.ctd;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Call;

public class CTDService
{
    public SDKErrorCode releaseCall(String ctdID)
        throws SDKException
    {
        if (null == ctdID)
        {
            SDKErrorCode sdkErrorCode = new SDKErrorCode();
            sdkErrorCode.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return sdkErrorCode;
        }
        
        Call call = new Call(ctdID);
        return call.releaseCall();
    }
    
    public SDKResult<Call> getCallStatus(String callID)
        throws SDKException
    {
        Call call = new Call(callID);
        return call.getStatus();
    }
    
    public SDKResult<String> dialCall(Call call)
        throws SDKException
    {
        SDKResult<String> result = null;
        if (null == call)
        {
            // 必填参数校验
            result = new SDKResult<String>();
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            result.setDescription(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return result;
        }

        result = call.dialCallRest(call);
        return result;
    }
}
