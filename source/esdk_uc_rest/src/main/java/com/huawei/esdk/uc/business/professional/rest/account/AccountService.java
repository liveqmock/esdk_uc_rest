package com.huawei.esdk.uc.business.professional.rest.account;

import java.util.List;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.Account;
import com.huawei.esdk.uc.domain.model.bean.BatchAccount;

public class AccountService
{
    
    public SDKResult<String> addAccount(String userId, Account account)
        throws SDKException
    {
        return account.addAccount(userId, account);
    }
    
    public SDKResult<BatchAccount> batchAddAccount(String userId, List<Account> accounts)
        throws SDKException
    {
        return new Account().batchAddAccount(userId, accounts);
    }
    
    public SDKErrorCode modifyAccount(String userId, Account account)
        throws SDKException
    {
        return account.modifyAccount(userId, account);
    }
    
    public SDKErrorCode deleteAccount(String userId, String accountId)
        throws SDKException
    {
        return new Account().deleteAccount(userId, accountId);
    }
    
    public SDKResult<BatchAccount> batchDelAccount(String userId, List<String> accountIds)
        throws SDKException
    {
        return new Account().batchDelAccount(userId, accountIds);
    }

    public SDKResult<BatchAccount> getAccount(String userId, String exactSearch, String condition, int pageCount, int pageNum)
        throws SDKException
    {
        return new Account().getAccount(userId, exactSearch, condition, pageCount, pageNum);
    }

    public SDKErrorCode modifyAcountPassword(String userId, Account account)
        throws SDKException
    {
        return new Account().modifyAcountPassword(userId, account);
    }

    public SDKErrorCode bindNum(String userId, Account account)
        throws SDKException
    {
        return new Account().bindNum(userId, account);
    }
    
}
