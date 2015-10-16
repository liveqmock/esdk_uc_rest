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
import com.huawei.esdk.uc.north.rest.bean.BatchAddAccountRequest;
import com.huawei.esdk.uc.north.rest.bean.BatchAddAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;
import com.huawei.esdk.uc.north.rest.bmu.resource.account.convert.AccountResourceConvert;

@Path("uc/bmu/batch_add_account")
public class BatchAddAccountResource
{
    
    private static final Logger LOGGER = Logger.getLogger(CTCResource.class);
    
    private static final AccountResourceConvert accountResourceConvert = new AccountResourceConvert();
    
    private static final AccountService accountService = new AccountService();
    
    /**
     * 批量添加账号
     * @param accts
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<BatchAddAccountResponse> batchAddAccount(BatchAddAccountRequest accts)
    {
        
        RestResponse<BatchAddAccountResponse> response = new RestResponse<BatchAddAccountResponse>();
        
        if (null == accts || StringUtils.isEmpty(accts.getUserId()) || null == accts.getAccounts()
            || accts.getAccounts().isEmpty())
        {
            response.setResultCode(String.valueOf(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC);
            return response;
        }
        
        try
        {
            SDKResult<BatchAccount> result =
                accountService.batchAddAccount(accts.getUserId(),
                    accountResourceConvert.getBatchAccountRest2Model(accts.getAccounts()));
            
            response = accountResourceConvert.getBatchAccountModel2Rest(result);
            return response;
        }
        catch (SDKException e)
        {
            LOGGER.error("batchAddAccount method SDK error", e);
            response.setResultCode(String.valueOf(e.getSdkErrCode()));
            response.setResultContext(e.getSdkErrDesc());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("batchAddAccount method error", e);
            response.setResultCode(String.valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE));
            response.setResultContext(ErrInfo.SDK_SYSTEM_ERRORDESC);
            return response;
        }
    }
}
