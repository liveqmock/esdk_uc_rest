package com.huawei.esdk.uc.north.rest.bmu.resource.account.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.common.CipherUtilsRest;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Account;
import com.huawei.esdk.uc.domain.model.bean.BatchAccount;
import com.huawei.esdk.uc.north.rest.bean.AccountResponse;
import com.huawei.esdk.uc.north.rest.bean.BatchAddAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.BatchDelAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.FailedAccount;
import com.huawei.esdk.uc.north.rest.bean.FailedDelAccount;
import com.huawei.esdk.uc.north.rest.bean.GetAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.RestResponse;

public class AccountResourceConvert
{
    
    public Account getAccountRest2Model(com.huawei.esdk.uc.north.rest.bean.Account rest) throws SDKException
    {
        Account account = new Account();
        account.setAccountType(rest.getAccountType());
        account.setAddr(rest.getAddr());
        account.setCellPhone(rest.getCellPhone());
        account.setDepartmentId(rest.getDepartmentId());
        account.setEmail(rest.getEmail());
        account.setFax(rest.getFax());
        account.setHomePhone(rest.getHomePhone());
        account.setLoginName(rest.getLoginName());
        account.setName(rest.getName());
        account.setOfficePhone(rest.getOfficePhone());
        account.setOtherPhone(rest.getOtherPhone());
        if (!StringUtils.isEmpty(rest.getPassword()))
        {
            String password = CipherUtilsRest.decodeFromBase64(rest.getPassword());
            if (StringUtils.isEmpty(password))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setPassword(password);
        }
        else
        {
            account.setPassword(rest.getPassword());
        }
        account.setRoleId(rest.getRoleId());
        account.setSex(rest.getSex());
        account.setShortPhone(rest.getShortPhone());
        account.setTitle(rest.getTitle());
        account.setUserLevel(rest.getUserLevel());
        
        return account;
    }
    
    public List<Account> getBatchAccountRest2Model(List<com.huawei.esdk.uc.north.rest.bean.Account> accounts) throws SDKException
    {
        List<Account> models = new ArrayList<Account>();
        Account model = null;
        for (com.huawei.esdk.uc.north.rest.bean.Account account : accounts)
        {
            model = getAccountRest2Model(account);
            models.add(model);
        }
        return models;
    }
    
    public RestResponse<BatchAddAccountResponse> getBatchAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<BatchAddAccountResponse> response = new RestResponse<BatchAddAccountResponse>();
        
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        BatchAccount batchAccount = result.getResult();
        if (null != batchAccount)
        {
            BatchAddAccountResponse addAccountResponse = new BatchAddAccountResponse();
            response.setResult(addAccountResponse);
            addAccountResponse.setSuccessAmount(String.valueOf(batchAccount.getSuccessAmount()));
            addAccountResponse.setFailedAmount(String.valueOf(batchAccount.getFailedAmount()));
            
            List<Account> accountIds = batchAccount.getAccountIds();
            if (null != accountIds && !accountIds.isEmpty())
            {
                List<String> restIds = new ArrayList<String>();
                addAccountResponse.setAccountIds(restIds);
                for (Account accountId : accountIds)
                {
                    restIds.add(accountId.getAccountId());
                }
            }
            
            List<Account> failedAccounts = batchAccount.getFailedAccounts();
            if (null != failedAccounts && !failedAccounts.isEmpty())
            {
                List<FailedAccount> failedRests = new ArrayList<FailedAccount>();
                addAccountResponse.setFailedAccounts(failedRests);
                FailedAccount failed = null;
                for (Account account : failedAccounts)
                {
                    failed = new FailedAccount();
                    failedRests.add(failed);
                    failed.setLoginName(account.getLoginName());
                    failed.setFailedReason(account.getFailedReason());
                }
            }
        }
        
        return response;
    }
    
    public Account getModifyAccountRest2Model(com.huawei.esdk.uc.north.rest.bean.Account rest)
    {
        Account account = new Account();
        account.setAccountId(rest.getAccountId());
        account.setAccountType(rest.getAccountType());
        account.setAddr(rest.getAddr());
        account.setCellPhone(rest.getCellPhone());
        account.setDepartmentId(rest.getDepartmentId());
        account.setEmail(rest.getEmail());
        account.setFax(rest.getFax());
        account.setHomePhone(rest.getHomePhone());
        account.setName(rest.getName());
        account.setOfficePhone(rest.getOfficePhone());
        account.setOtherPhone(rest.getOtherPhone());
        account.setRoleId(rest.getRoleId());
        account.setSex(rest.getSex());
        account.setShortPhone(rest.getShortPhone());
        account.setTitle(rest.getTitle());
        account.setUserLevel(rest.getUserLevel());
        
        return account;
    }

    public RestResponse<BatchDelAccountResponse> getBatchDelAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<BatchDelAccountResponse> response = new RestResponse<BatchDelAccountResponse>();
        
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        BatchAccount model = result.getResult();
        if (null != model)
        {
            BatchDelAccountResponse rest = new BatchDelAccountResponse();
            response.setResult(rest);
            rest.setFailedAmount(String.valueOf(model.getFailedAmount()));
            
            // modify by cWX191990, 批量删除帐号不返回失败的信息，取值错误
            //List<Account> accts =model.getAccountIds();
            List<Account> accts =model.getFailedAccounts();
            
            
            if (null != accts && !accts.isEmpty())
            {
                List<FailedDelAccount> failedAccounts = new ArrayList<FailedDelAccount>();
                rest.setFailedAccounts(failedAccounts);
                FailedDelAccount failed = null;
                for (Account acct : accts)
                {
                    failed = new FailedDelAccount();
                    failed.setAccountId(acct.getAccountId());
                    failed.setFailedReason(acct.getFailedReason());
                    failedAccounts.add(failed);
                }
            }
        }
        
        return response;
    }

    public RestResponse<GetAccountResponse> getAccountModel2Rest(SDKResult<BatchAccount> result)
    {
        RestResponse<GetAccountResponse> response = new RestResponse<GetAccountResponse>();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        BatchAccount modelAccount = result.getResult();
        if (null != modelAccount)
        {
            GetAccountResponse accoutRes = new GetAccountResponse();
            response.setResult(accoutRes);
            accoutRes.setAmount(modelAccount.getSuccessAmount());
            
            List<Account> accounts = modelAccount.getAccountIds();
            if (null != accounts && !accounts.isEmpty())
            {
                List<AccountResponse> rests = new ArrayList<AccountResponse>();
                accoutRes.setAccounts(rests);
                AccountResponse rest = null;
                for (Account account : accounts)
                {
                    rest = new AccountResponse();
                    rests.add(rest);
                    rest.setAccountType(account.getAccountType());
                    rest.setAccountId(account.getAccountId());
                    rest.setLoginName(account.getLoginName());
                    rest.setName(account.getName());
                    rest.setSex(account.getSex());
                    rest.setHomePhone(account.getHomePhone());
                    rest.setCellPhone(account.getCellPhone());
                    rest.setOfficePhone(account.getOfficePhone());
                    rest.setShortPhone(account.getShortPhone());
                    rest.setOtherPhone(account.getOtherPhone());
                    rest.setFax(account.getFax());
                    rest.setEmail(account.getEmail());
                    rest.setAddress(account.getAddr());
                    rest.setTitle(account.getTitle());
                    rest.setDepartmentId(account.getDepartmentId());
                    rest.setUserLevel(account.getUserLevel());
                    rest.setRoleId(account.getRoleId());
                    rest.setBindNum(account.getBindNum());
                }
            }
        }
        
        return response;
    }

    public Account getAccountPasswordRest2Model(com.huawei.esdk.uc.north.rest.bean.Account rest) throws SDKException
    {
        Account account = new Account();
        account.setAccountId(rest.getAccountId());
        account.setLoginName(rest.getLoginName());
        
        if (!StringUtils.isEmpty(rest.getOldPassword()))
        {
            String oldPsw = CipherUtilsRest.decodeFromBase64(rest.getOldPassword());
            if (StringUtils.isEmpty(oldPsw))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setOldPassword(oldPsw);
        }
        else
        {
            account.setOldPassword(rest.getOldPassword());
        }
        
        if (!StringUtils.isEmpty(rest.getNewPassword()))
        {
            String newPsw = CipherUtilsRest.decodeFromBase64(rest.getNewPassword());
            if (StringUtils.isEmpty(newPsw))
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
            account.setNewPassword(newPsw);
        }
        else
        {
            account.setNewPassword(rest.getNewPassword());
        }
        
        return account;
    }

    public Account getAccountBindNumRest2Model(com.huawei.esdk.uc.north.rest.bean.Account rest)
    {
        Account account = new Account();
        account.setAccountId(rest.getAccountId());
        account.setBindNum(rest.getBindNum());
        
        return account;
    }
    
}
