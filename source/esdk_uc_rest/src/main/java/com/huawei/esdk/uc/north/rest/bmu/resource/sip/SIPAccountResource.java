package com.huawei.esdk.uc.north.rest.bmu.resource.sip;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.sip.SIPAccountService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.bean.SIPRequest;
import com.huawei.esdk.uc.north.rest.bean.SIPResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.sip.convert.SIPAccountConvert;

@Path("uc/bmu/sip")
public class SIPAccountResource
{
    private static final Logger LOGGER = Logger.getLogger(SIPAccountResource.class);
    
    private SIPAccountService sipAccountService = new SIPAccountService();
    
    private SIPAccountConvert sipAccountConvert = new SIPAccountConvert();
    
    /**
     * 添加SIP号码
     * @param acct
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SIPResponse addSIP(SIPRequest acct)
    {
        SIPResponse response = new SIPResponse();
        
        if (null == acct || null == acct.getSip())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result =
                sipAccountService.addSIP(acct.getUserId(), sipAccountConvert.getSIPRest2Model(acct.getSip()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("addSIP method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("addSIP method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 修改SIP号码
     * @param acct
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SIPResponse modifySIP(SIPRequest acct)
    {
        SIPResponse response = new SIPResponse();
        
        if (null == acct)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result =
                sipAccountService.modifySIP(acct.getUserId(), sipAccountConvert.getSIPRest2Model(acct.getSip()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifySIP method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifySIP method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
