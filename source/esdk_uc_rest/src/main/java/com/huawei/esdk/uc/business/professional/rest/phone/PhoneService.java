package com.huawei.esdk.uc.business.professional.rest.phone;

import java.util.List;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.Phone;
import com.huawei.esdk.uc.domain.model.bean.PhoneInfo;
import com.huawei.esdk.uc.domain.model.bean.PhoneStateList;

public class PhoneService
{
    public SDKResult<PhoneStateList> queryPhoneState(String userId, List<PhoneInfo> phoneInfoList) throws SDKException
    {
        return new Phone().queryPhoneState(userId, phoneInfoList);
    }
}
