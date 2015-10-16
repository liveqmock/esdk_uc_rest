package com.huawei.esdk.uc.north.rest.bmu.resource.sip;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.business.professional.rest.sip.SIPAccountService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.bean.GatewayList;
import com.huawei.esdk.uc.north.rest.bean.GatewayResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.sip.convert.SIPAccountConvert;

@Path("uc/bmu/gateway")
public class GatewayResource
{
    private static final Logger LOGGER = Logger.getLogger(GatewayResource.class);
    
    private SIPAccountService sipAccountService = new SIPAccountService();
    
    private SIPAccountConvert sipAccountConvert = new SIPAccountConvert();
    
    /**
     * 查询网关列表
     * @param acct
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GatewayResponse queryGateway(@QueryParam("userId") String userId)
    {
        GatewayResponse response = new GatewayResponse();
        
        if (null == userId)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<GatewayList> result = sipAccountService.queryGateway(userId);
            
            response = sipAccountConvert.getGatewayMode2Rest(result);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryGateway method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryGateway method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
