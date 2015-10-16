package com.huawei.esdk.uc.north.rest.bmu.resource.userlevel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.userlevel.UserLevelService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.UserLevel;
import com.huawei.esdk.uc.north.rest.bean.QueryUserLevelResponse;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.userlevel.convert.UserLevelResourceConvert;

@Path("uc/bmu/userlevel")
public class BMUUserLevelResource
{
    
    private static final Logger LOGGER = Logger.getLogger(BMUUserLevelResource.class);
    
    private static final UserLevelResourceConvert userLevelResourceConvert = new UserLevelResourceConvert();
    
    private static final UserLevelService userLevelService = new UserLevelService();
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<QueryUserLevelResponse> queryUserLevel(
        @QueryParam("userId") String userId,
        @QueryParam("pageCount") String pageCount,
        @QueryParam("pageNum") String pageNum)
    {
        RestResponse<QueryUserLevelResponse> response = new RestResponse<QueryUserLevelResponse>();
        
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(pageCount) ||
                StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<UserLevel> result =
                userLevelService.queryUserLevel(userId,pageCount, pageNum);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            response.setResult(userLevelResourceConvert.queryUserLevelModal2Rest(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryUserLevel method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryUserLevel method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
