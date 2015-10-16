package com.huawei.esdk.uc.north.rest.bmu.resource.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.business.professional.rest.account.AccountService;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.bean.BatchAccount;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCResource;
import com.huawei.esdk.uc.north.rest.bean.BatchDelAccountRequest;
import com.huawei.esdk.uc.north.rest.bean.BatchDelAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.account.convert.AccountResourceConvert;

@Path("uc/bmu/batch_delete_account")
public class BatchDelAccountResource
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCResource.class);
    
    private static final AccountResourceConvert accountResourceConvert = new AccountResourceConvert();
    
    private static final AccountService accountService = new AccountService();
    
    /**
     * 批量删除账号
     * @param accts
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<BatchDelAccountResponse> batchDelAccount(BatchDelAccountRequest accts)
    {
        
        RestResponse<BatchDelAccountResponse> response = new RestResponse<BatchDelAccountResponse>();
        
        if (null == accts || StringUtils.isEmpty(accts.getUserId()) || null == accts.getAccountIds()
            || accts.getAccountIds().isEmpty())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<BatchAccount> result =
                accountService.batchDelAccount(accts.getUserId(), accts.getAccountIds());
            
            response = accountResourceConvert.getBatchDelAccountModel2Rest(result);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("batchDelAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("batchDelAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
