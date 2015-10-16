package com.huawei.esdk.uc.north.rest.app.resource.affiche;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.affiche.AfficheService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.app.resource.affiche.convert.AfficheResourceConvert;
import com.huawei.esdk.uc.north.rest.bean.AfficheRequest;
import com.huawei.esdk.uc.north.rest.bean.AfficheResponse;

@Path("uc/appserver/affiche")
public class AfficheResource
{
    private static final Logger LOGGER = Logger.getLogger(AfficheResource.class);
    
    private static final AfficheResourceConvert afficheResourceConvert = new AfficheResourceConvert();
    
    private AfficheService afficheService = new AfficheService();
    
    /**
     * 发送公告
     * @param confInfo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AfficheResponse sendAffiche(AfficheRequest affiche)
    {
        AfficheResponse response = new AfficheResponse();
        
        if (null == affiche)
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = afficheService.sendAffiche(afficheResourceConvert.getAfficheRest2Model(affiche));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("sendAffiche method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("sendAffiche method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
