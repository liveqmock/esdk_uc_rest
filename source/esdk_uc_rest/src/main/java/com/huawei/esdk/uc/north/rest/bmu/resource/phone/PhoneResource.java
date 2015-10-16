package com.huawei.esdk.uc.north.rest.bmu.resource.phone;

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
import com.huawei.esdk.uc.business.professional.rest.phone.PhoneService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.bean.PhoneInfo;
import com.huawei.esdk.uc.domain.model.bean.PhoneStateList;
import com.huawei.esdk.uc.north.rest.bean.QueryPhoneStateRequest;
import com.huawei.esdk.uc.north.rest.bean.QueryPhoneStateResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.phone.convert.PhoneResourceConvert;

@Path("uc/bmu/phone_state")
public class PhoneResource
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(PhoneResource.class);
    
    /**
     * 号码状态层对象
     */
    private static final PhoneService PHONE_SERVICE = new PhoneService();
    
    /**
     * 号码状态转换对象
     */
    private static final PhoneResourceConvert PHONE_RESOURCE_CONVERT = new PhoneResourceConvert();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryPhoneStateResponse queryPhoneState(QueryPhoneStateRequest phoneStateRequest)
    {
        QueryPhoneStateResponse response = new QueryPhoneStateResponse();
        
        if (null == phoneStateRequest || StringUtils.isEmpty(phoneStateRequest.getUserId())
            || null == phoneStateRequest.getPhoneList() || phoneStateRequest.getPhoneList().isEmpty())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            List<PhoneInfo> pInfoList = PHONE_RESOURCE_CONVERT.queryPhoneStateRest2Model(phoneStateRequest.getPhoneList());
            
            SDKResult<PhoneStateList> result =
                PHONE_SERVICE.queryPhoneState(phoneStateRequest.getUserId(), pInfoList);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            response.setPhoneStateList(PHONE_RESOURCE_CONVERT.queryPhoneStateModel2Rest(result.getResult()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryPhoneState method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryPhoneState method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
