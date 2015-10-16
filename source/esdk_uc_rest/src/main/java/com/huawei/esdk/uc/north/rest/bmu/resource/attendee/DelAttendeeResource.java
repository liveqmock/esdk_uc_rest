package com.huawei.esdk.uc.north.rest.bmu.resource.attendee;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.attendee.AttendeeService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.bean.DelAttendeeFailedList;
import com.huawei.esdk.uc.north.rest.bean.DelAttendeeInfo;
import com.huawei.esdk.uc.north.rest.bean.DelAttendeeRequest;
import com.huawei.esdk.uc.north.rest.bean.DelAttendeeResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.attendee.convert.AttendeeResourceConvert;

@Path("uc/bmu/delete_attendee")
public class DelAttendeeResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(DelAttendeeResource.class);
    
    /**
     * 与会人服务层对象
     */
    private static final AttendeeService ATTENDEE_SERVICE = new AttendeeService();
    
    /**
     * 与会人源转换对象
     */
    private static final AttendeeResourceConvert ATTENDEE_RESOURCE_CONVERT = new AttendeeResourceConvert();
    
    /** 
    * 删除与会人
    * 
    * @param attendeeRequest 删除与会人对象，包括与会人列表
    * @return DelAttendeeResponse 操作结果JSON对象
    * @see [类、类#方法、类#成员]
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DelAttendeeResponse deleteAttendee(DelAttendeeRequest attendeeRequest)
    {
        DelAttendeeResponse response = new DelAttendeeResponse();
        
        // 参数判空
        if (isEmptyDelAttendeeRequest(attendeeRequest))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<DelAttendeeFailedList> result =
                ATTENDEE_SERVICE.deleteAttendee(ATTENDEE_RESOURCE_CONVERT.getDeleteAttendeeRest2Model(attendeeRequest));
            
            // 转换结果
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            if (null != result.getResult())
            {
                response.setAttendeeFailedInfos(ATTENDEE_RESOURCE_CONVERT.getDeleteAttendeeModel2Rest(result.getResult()));
            }
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteAttendee method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteAttendee method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
    private boolean isEmptyDelAttendeeRequest(DelAttendeeRequest attendeeRequest)
    {
        if (null == attendeeRequest)
        {
            return true;
        }
        
        if (StringUtils.isEmpty(attendeeRequest.getConfId()) || StringUtils.isEmpty(attendeeRequest.getGwIp())
            || StringUtils.isEmpty(attendeeRequest.getUserId()))
        {
            return true;
        }
        
        if (null == attendeeRequest.getAttendeeInfos() || attendeeRequest.getAttendeeInfos().isEmpty())
        {
            return true;
        }
        
        for (DelAttendeeInfo info : attendeeRequest.getAttendeeInfos())
        {
            if (StringUtils.isEmpty(info.getAccount()) || StringUtils.isEmpty(info.getAttNumber()))
            {
                return true;
            }
        }
        
        return false;
    }
}
