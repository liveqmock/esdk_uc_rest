package com.huawei.esdk.uc.north.rest.app.resource.ctc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.ctc.CTCService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.uc.north.rest.bean.ctc.UpgradeReqBean;
import com.huawei.esdk.uc.north.rest.bean.ctc.UpgradeResBean;

@Path("uc/appserver/ctc_upgrade")
public class CTCUpgrade
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCUpgrade.class);
    
    /**
     * 升级语音会议为数据会议
     * @param upgradeReqBean
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UpgradeResBean upgradeAudioToDataConf(UpgradeReqBean upgradeReqBean)
    {
        CTCService service = new CTCService();
        
        UpgradeResBean response = new UpgradeResBean();
        ResHeaderBean header = new ResHeaderBean();
        response.setHeader(header);
        
        if (null == upgradeReqBean || StringUtils.isEmpty(upgradeReqBean.getConfId()))
        {
            header.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result = service.upgradeAudioToDataConf(upgradeReqBean.getConfId(), upgradeReqBean.getAccount());
            header.setResultCode(String.valueOf(result.getErrCode()));
            header.setResultContext(StringUtils.avoidNull(result.getDescription()));
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("getAttendee method SDK error", e);
            header.setResultCode(String.valueOf(e.getSdkErrCode()));
            header.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getAttendee method error", e);
            header.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
