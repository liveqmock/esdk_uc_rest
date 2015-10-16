package com.huawei.esdk.uc.north.rest.bmu.resource.ctc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.DateUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.bean.MeetingBaseInfo;
import com.huawei.esdk.uc.north.rest.bean.RestErrCode;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.ctc.convert.CTCResourceConvert;

@Path("uc/bmu/ctc")
public class BMUCTCResource
{
    private static final Logger LOGGER = Logger.getLogger(BMUCTCResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    /**
     * 发起CTC会议
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> sheduleMeeting(MeetingBaseInfo confInfo)
    {
        RestResponse<String> response = new RestResponse<String>();
        
        if (null == confInfo)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (!validDate(confInfo.getStartTime()) || !validDate(confInfo.getEndTime()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<String> result = ctcService.scheduleMeeting(ctcResourceConvert.getMeetingInfoRest2Model(confInfo));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            if(0 == result.getErrCode() && null != result.getResult())
            {
                response.setResult(result.getResult());
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("sheduleMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("sheduleMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    /**
     * 修改CTC会议
     * @param confInfo
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestErrCode modifyMeeting(MeetingBaseInfo confInfo)
    {
        RestErrCode response = new RestErrCode();
        
        if (null == confInfo)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (!validDate(confInfo.getStartTime()) || !validDate(confInfo.getEndTime()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = ctcService.modifyMeeting(ctcResourceConvert.getMeetingInfoRest2Model(confInfo));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }

    private boolean validDate(String dateTime)
    {
        if (StringUtils.isEmpty(dateTime))
        {
            return false;
        }
        
        if (null == DateUtils.stringToDate(dateTime, "yyyy-MM-dd HH:mm:ss"))
        {
            return false;
        }
        
        return true;
    }
}
