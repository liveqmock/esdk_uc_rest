package com.huawei.esdk.uc.north.rest.bmu.resource.sip;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.sip.SIPAccountService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.bean.SIPList;
import com.huawei.esdk.uc.north.rest.bean.SIPBatchRequest;
import com.huawei.esdk.uc.north.rest.bean.SIPBatchResponse;
import com.huawei.esdk.uc.north.rest.bean.SIPQueryRequest;
import com.huawei.esdk.uc.north.rest.bean.SIPQueryResponse;
import com.huawei.esdk.uc.north.rest.bean.SIPRequest;
import com.huawei.esdk.uc.north.rest.bean.SIPResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.sip.convert.SIPAccountConvert;

@Path("uc/bmu/sipcondition")
public class SIPConditionResource
{
    private static final Logger LOGGER = Logger.getLogger(SIPConditionResource.class);
    
    private SIPAccountService sipAccountService = new SIPAccountService();
    
    private SIPAccountConvert sipAccountConvert = new SIPAccountConvert();
    
    /**
     * 查询SIP号码
     * @param sip
     * @return
     */
    @POST
    @Path("/query_sip")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SIPQueryResponse querySip(SIPQueryRequest sip)
    {
        SIPQueryResponse response = new SIPQueryResponse();
        
        if (null == sip)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<SIPList> result =
                sipAccountService.querySip(sip.getUserId(), sipAccountConvert.getQuerySipRest2Model(sip));
            
            response = sipAccountConvert.getQuerySipModel2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("querySip method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("querySip method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 删除SIP号码
     * @param acct
     * @return
     */
    @POST
    @Path("/delete_sip")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SIPResponse deleteSip(SIPRequest acct)
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
                sipAccountService.deleteSip(acct.getUserId(), sipAccountConvert.getDeleteSipRest2Model(acct.getSip()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteSip method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteSip method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 批量删除SIP号码
     * @param acct
     * @return
     */
    @POST
    @Path("/batch_delete_sip")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SIPBatchResponse batchDeleteSip(SIPBatchRequest acct)
    {
        SIPBatchResponse response = new SIPBatchResponse();
        
        if (null == acct || null == acct.getSips() || acct.getSips().isEmpty())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<SIPList> result =
                sipAccountService.batchDeleteSip(acct.getUserId(),
                    sipAccountConvert.getBatchDelSipRest2Model(acct.getSips()));
            
            response = sipAccountConvert.getBatchDeleteSipModel2Rest(result);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("batchDeleteSip method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("batchDeleteSip method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
