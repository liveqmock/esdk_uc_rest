package com.huawei.esdk.uc.north.rest.app.resource.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.userprofile.UserProfileService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.PersonInfo;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.convert.UserProfileConvert;
import com.huawei.esdk.uc.north.rest.bean.QueryPersonInfoResponse;

@Path("uc/appserver/person_info")
public class PersonInfoResource
{
    
    private static final Logger LOGGER = Logger.getLogger(PersonInfoResource.class);
    
    private UserProfileService userProfileService = new UserProfileService();
    
    private UserProfileConvert userProfileConvert = new UserProfileConvert();
    
    /**
     * 查询个人详情
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public QueryPersonInfoResponse queryPersonInfo( 
        @QueryParam("staffAccount") String staffAccount)
    {
        QueryPersonInfoResponse response = new QueryPersonInfoResponse();
        
        if (StringUtils.isEmpty(staffAccount))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            SDKResult<PersonInfo> result =
                userProfileService.queryPersonInfo(" ", staffAccount);
            response = userProfileConvert.getQueryPersonInfoModel2Rest(result);
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryPersonInfo method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryPersonInfo method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
