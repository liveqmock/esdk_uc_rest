package com.huawei.esdk.uc.north.rest.bmu.resource.ctc;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.bean.BatchDeleteMeetingParam;
import com.huawei.esdk.uc.north.rest.bean.DeleteMeetingParam;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.ctc.convert.CTCResourceConvert;

@Path("uc/bmu/batch_delete_ctc")
public class BMUCTCBactchDeleteResource
{
    private static final Logger LOGGER = Logger.getLogger(BMUCTCBactchDeleteResource.class);
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    private static final CTCService ctcService = new CTCService();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<DeleteMeetingParam>> deleteMeeting(BatchDeleteMeetingParam params)
    {
        RestResponse<List<DeleteMeetingParam>> response =
            new RestResponse<List<DeleteMeetingParam>>();
        
        if (StringUtils.isEmpty(params.getUserId()) 
            || null == params.getDeleteItem())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<List<com.huawei.esdk.uc.domain.model.bean.DeleteMeetingParam>> result = 
                ctcService.deleteMeeting(params.getUserId(),
                ctcResourceConvert.getDeleteMeetingRest2Modal(params.getDeleteItem()));
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(result.getDescription());
            
            response.setResult(ctcResourceConvert.getDeleteMeetingModal2Rest(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteMeeting method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteMeeting method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
        
    }
}
