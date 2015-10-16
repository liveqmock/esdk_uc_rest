package com.huawei.esdk.uc.north.rest.app.resource.ctc;

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
import com.huawei.esdk.uc.domain.model.bean.TerminalInConfInfo;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.convert.CTCResourceConvert;
import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.uc.north.rest.bean.ctc.ReportTerminalTypeReqBean;
import com.huawei.esdk.uc.north.rest.bean.ctc.ReportTerminalTypeResBean;
import com.huawei.esdk.uc.north.rest.bean.ctc.ReportTerminalTypeResBody;

@Path("uc/appserver/ctc_terminal")
public class CTCTerminalType
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCTerminalType.class);
    
    private static final CTCService ctcService = new CTCService();
    
    private static final CTCResourceConvert ctcResourceConvert = new CTCResourceConvert();
    
    /**
     * 上报终端
     * @param reportTerminalTypeReqBean
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReportTerminalTypeResBean reportType(ReportTerminalTypeReqBean reportTerminalTypeReqBean)
    {
        ReportTerminalTypeResBean response = new ReportTerminalTypeResBean();
        ResHeaderBean header = new ResHeaderBean();
        response.setHeader(header);
        if (null == reportTerminalTypeReqBean || StringUtils.isEmpty(reportTerminalTypeReqBean.getConfId()))
        {
            header.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        try
        {
            SDKResult<TerminalInConfInfo> result =
                ctcService.informTerminalType(reportTerminalTypeReqBean.getAccount(),
                    reportTerminalTypeReqBean.getConfId());
            header.setResultCode(String.valueOf(result.getErrCode()));
            header.setResultContext(result.getDescription());
            
            ReportTerminalTypeResBody body = ctcResourceConvert.getCTCTerminalInConfInfoModel2Rest(result.getResult());
            
            if (null != body)
            {
                response.setBody(body);
            }
        }
        catch (SDKException e)
        {
            LOGGER.error("reportType method SDK error", e);
            header.setResultCode(String.valueOf(e.getSdkErrCode()));
            header.setResultContext(e.getSdkErrDesc());
        }
        catch (Exception e)
        {
            LOGGER.error("reportType method error", e);
            header.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            header.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
        }
        return response;
    }
}
