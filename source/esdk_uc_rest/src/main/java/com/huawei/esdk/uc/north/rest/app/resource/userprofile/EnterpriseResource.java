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
import com.huawei.esdk.uc.domain.model.bean.EnterpriseList;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.convert.UserProfileConvert;
import com.huawei.esdk.uc.north.rest.bean.QueryEnterpriseResponse;

@Path("uc/appserver/enterprise")
public class EnterpriseResource
{
    
    private static final Logger LOGGER = Logger.getLogger(EnterpriseResource.class);
    
    private UserProfileService userProfileService = new UserProfileService();
    
    private UserProfileConvert userProfileConvert = new UserProfileConvert();
    
    /**
     * 查询企业通讯录
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public QueryEnterpriseResponse queryEnterprise( 
        @QueryParam("departmentId") String deptId, 
        @QueryParam("pageCount") String pageCount, 
        @QueryParam("pageNum") String pageNum)
    {
        QueryEnterpriseResponse response = new QueryEnterpriseResponse();
        
        if (StringUtils.isEmpty(deptId) || StringUtils.isEmpty(pageCount) || StringUtils.isEmpty(pageNum))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            int pageCountTemp = Integer.parseInt(pageCount);
            int pageNumTemp = Integer.parseInt(pageNum);
            
            SDKResult<EnterpriseList> result =
                userProfileService.queryEnterprise("", deptId, pageCountTemp, pageNumTemp);
            response = userProfileConvert.getEnterpriseModel2Rest(result);
            
            return response;
        }
        catch (NumberFormatException e)
        {
            // 参数错误
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryEnterprise method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryEnterprise method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
