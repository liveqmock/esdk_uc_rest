package com.huawei.esdk.uc.north.rest.bmu.resource.role;

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
import com.huawei.esdk.uc.business.professional.rest.role.RoleService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Role;
import com.huawei.esdk.uc.north.rest.bean.QueryRoleInfoResponse;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.role.convert.RoleResourceConvert;

@Path("uc/bmu/role")
public class BMURoleResource
{
    
    private static final Logger LOGGER = Logger.getLogger(BMURoleResource.class);
    
    private static final RoleResourceConvert roleResourceConvert = new RoleResourceConvert();
    
    private static final RoleService roleService = new RoleService();
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<QueryRoleInfoResponse> queryRole(@QueryParam("userId") String userId,
        @QueryParam("pageCount") String pageCount, @QueryParam("pageNum") String pageNum,
        @QueryParam("lang") String lang)
    {
        RestResponse<QueryRoleInfoResponse> response = new RestResponse<QueryRoleInfoResponse>();
        
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(pageCount) || StringUtils.isEmpty(pageNum)
            || StringUtils.isEmpty(lang))
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<Role> result = roleService.queryRole(userId, pageCount, pageNum, lang);
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            response.setResult(roleResourceConvert.queryRoleModal2Rest(result.getResult()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("queryRole method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryRole method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
    
}
