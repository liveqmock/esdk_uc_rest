package com.huawei.esdk.uc.north.rest.bmu.resource.attendee;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.attendee.AttendeeService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Attendee;
import com.huawei.esdk.uc.north.rest.bean.AttendeeRequest;
import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.uc.north.rest.bmu.resource.attendee.convert.AttendeeResourceConvert;

@Path("uc/bmu/transfer_chairman")
public class TransferChairmanResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(TransferChairmanResource.class);
    
    /**
     * 与会人源转换对象
     */
    private static final AttendeeResourceConvert ATTENDEE_RESOURCE_CONVERT = new AttendeeResourceConvert();
    
    /**
     * 与会人服务层对象
     */
    private static final AttendeeService ATTENDEE_SERVICE = new AttendeeService();
    
    /**
     * 主席权限转移
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResHeaderBean transferChairman(AttendeeRequest request)
    {
        ResHeaderBean response = new ResHeaderBean();
        
        if (null == request)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        Attendee attendee = ATTENDEE_RESOURCE_CONVERT.getTransferChairmanRest2Model(request);
        
        try
        {
            SDKErrorCode result = ATTENDEE_SERVICE.transferChairman(attendee);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("transferChairman method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("transferChairman method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
