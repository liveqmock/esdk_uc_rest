package com.huawei.esdk.uc.north.rest.app.resource.ctd;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.base.BaseResource;
import com.huawei.esdk.uc.business.professional.rest.ctd.CTDService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Call;
import com.huawei.esdk.uc.north.rest.bean.CallBean;
import com.huawei.esdk.uc.north.rest.bean.CallResBean;

@Path("uc/appserver/ctd")
public class CTDResource extends BaseResource
{
    private static final Logger LOGGER = Logger.getLogger(CTDResource.class);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CallResBean createCTD(CallBean callReq)
    {
        CallResBean resBean = new CallResBean();
        
        if (null == callReq || StringUtils.isEmpty(callReq.getAccount())
            || StringUtils.isEmpty(callReq.getCallee())
            || StringUtils.isEmpty(callReq.getCaller()))
        {
            resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return resBean;
        }
        
        CTDService service = new CTDService();
        Call call = new Call();
        call.setInitiator(callReq.getAccount());
        call.setCallee(callReq.getCallee());
        call.setCalling(callReq.getCaller());
        
        try
        {
            SDKResult<String> result = service.dialCall(call);
            
            resBean.setResultCode(String.valueOf(result.getErrCode()));
            resBean.setResultContext(StringUtils.avoidNull(result.getResult()));
            return resBean;
        }
        catch (SDKException e)
        {
            LOGGER.error("createCTD method SDK error", e);
            resBean.setResultCode(String.valueOf(e.getSdkErrCode()));
            resBean.setResultContext(null != e.getSdkErrDesc() ? e.getSdkErrDesc() : e.getMessage());
            return resBean;
        }
        catch (Exception e)
        {
            LOGGER.error("createCTD method error", e);
            resBean.setResultCode(String.valueOf(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR));
            resBean.setResultContext("eSDK system error");
            return resBean;
        }
    }

}
