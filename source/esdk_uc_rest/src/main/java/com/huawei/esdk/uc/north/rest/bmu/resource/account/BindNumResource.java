package com.huawei.esdk.uc.north.rest.bmu.resource.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.account.AccountService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCResource;
import com.huawei.esdk.uc.north.rest.bean.AddAccountRequest;
import com.huawei.esdk.uc.north.rest.bean.ResHeaderBean;
import com.huawei.esdk.uc.north.rest.bmu.resource.account.convert.AccountResourceConvert;

@Path("uc/bmu/bind_num")
public class BindNumResource
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCResource.class);
    
    private static final AccountResourceConvert accountResourceConvert = new AccountResourceConvert();
    
    private static final AccountService accountService = new AccountService();
    
    /**
     * 绑定号码
     * @param acct
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResHeaderBean bindNum(AddAccountRequest acct)
    {
        
        ResHeaderBean response = new ResHeaderBean();
        
        if (null == acct || StringUtils.isEmpty(acct.getUserId()) || null == acct.getAccount())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKErrorCode result =
                accountService.bindNum(acct.getUserId(),
                    accountResourceConvert.getAccountBindNumRest2Model(acct.getAccount()));
            
            response.setResultCode(String.valueOf(result.getErrCode()));
            response.setResultContext(StringUtils.avoidNull(result.getDescription()));
            
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("bindNum method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("bindNum method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
