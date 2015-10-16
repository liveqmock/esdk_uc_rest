package com.huawei.esdk.uc.business.professional.rest.userprofile;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.AddressListInfo;
import com.huawei.esdk.uc.domain.model.PersonInfo;
import com.huawei.esdk.uc.domain.model.bean.EmployeeList;
import com.huawei.esdk.uc.domain.model.bean.EnterpriseList;

public class UserProfileService
{
    
    public SDKResult<AddressListInfo> queryAddrList(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        return new AddressListInfo().queryAddrListRest(account, condition, pagecount, pagenum);
    }
    
    public SDKResult<PersonInfo> queryPersonInfo(String account, String staffAccount)
        throws SDKException
    {
        return new PersonInfo().queryPersonInfoRest(account, staffAccount);
    }
    
    public SDKResult<EmployeeList> queryEmployee(String account, String condition, int pagecount, int pagenum)
        throws SDKException
    {
        return new PersonInfo().queryEmployeeRest(account, condition, pagecount, pagenum);
    }
    
    public SDKResult<EnterpriseList> queryEnterprise(String account, String deptId, int pagecount, int pagenum)
        throws SDKException
    {
        return new PersonInfo().queryEnterpriseRest(account, deptId, pagecount, pagenum);
    }
    
}
