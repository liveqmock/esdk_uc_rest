package com.huawei.esdk.uc.north.rest.app.resource.callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.base.BaseResource;
import com.huawei.esdk.uc.business.professional.rest.common.UCRestCallbackRegisterService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.bean.MessageNotification;
import com.huawei.esdk.uc.north.rest.bean.MessageNotifications;
import com.huawei.esdk.uc.north.rest.bean.RestErrCode;

@Path("uc/appserver/callback")
public class CallbackResource extends BaseResource
{
    private static final Logger LOGGER = Logger.getLogger(CallbackResource.class);
    
    private UCRestCallbackRegisterService callbackService = ApplicationContextUtil.getBean("ucRestCallbackRegisterService");
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode registerNotification(MessageNotifications messageNotifications)
    {
        RestErrCode resBean = new RestErrCode();
        
        if (null == messageNotifications || null == messageNotifications.getCallbackUrls()
        		|| messageNotifications.getCallbackUrls().isEmpty())
        {
            resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return resBean;
        }
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (MessageNotification messageNotification : messageNotifications.getCallbackUrls())
        {
            if (StringUtils.isEmpty(messageNotification.getModule())
            		|| StringUtils.isEmpty(messageNotification.getWsUri()))
            {
                resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
                resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
                return resBean;
            }
            map.put(messageNotification.getModule(), messageNotification.getWsUri());
        }
        
        try
        {
            SDKErrorCode result = callbackService.register(map);
            
            resBean.setResultCode(result.getErrCode() + "");
            resBean.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return resBean;
        }
        catch (Exception e)
        {
            LOGGER.error("registerNotification method error", e);
            resBean.setResultCode(String.valueOf(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR));
            resBean.setResultContext("eSDK system error");
            return resBean;
        }
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode unRegister(@QueryParam("modules") String modules)
    {
        RestErrCode resBean = new RestErrCode();
        if (StringUtils.isEmpty(modules))
        {
            resBean.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            resBean.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return resBean;
        }
        try
        {
            List<String> moduleList = new ArrayList<String>();
            for (String module : modules.split(","))
            {
                if (!StringUtils.isEmpty(module))
                {
                    moduleList.add(module);
                }
            }
            
            SDKErrorCode result = callbackService.unregister(moduleList);
            
            resBean.setResultCode(result.getErrCode() + "");
            resBean.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return resBean;
        }
        catch (Exception e)
        {
            LOGGER.error("registerNotification method error", e);
            resBean.setResultCode(String.valueOf(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR));
            resBean.setResultContext("eSDK system error");
            return resBean;
        }
    }
    
}
