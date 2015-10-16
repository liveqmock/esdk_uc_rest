package com.huawei.esdk.uc.north.rest.bmu.resource.ctc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.DateUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Conference;
import com.huawei.esdk.uc.domain.model.bean.PagedList;
import com.huawei.esdk.uc.north.rest.bean.BatchQueryMeetingParam;
import com.huawei.esdk.uc.north.rest.bean.QueryMeetingResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.ctc.convert.CTCResourceConvert;

@Path("uc/bmu/batch_query_ctc")
public class BMUCTCBactchQueryResource
{
    private static final Logger LOGGER = Logger.getLogger(BMUCTCBactchQueryResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    /**
     * 查询CTC会议列表
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryMeetingResponse queryMeeting(BatchQueryMeetingParam param)
    {
        QueryMeetingResponse response = new QueryMeetingResponse();
        
        if (null == param)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        if (!validDate(param.getStartTime()) || !validDate(param.getEndTime()))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<PagedList<Conference>> result = ctcService.queryMeeting(ctcResourceConvert.getQueryMeetingRest2Modal(param));
            
            response = ctcResourceConvert.getQueryMeetingModal2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryMeeting method error", e);
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
