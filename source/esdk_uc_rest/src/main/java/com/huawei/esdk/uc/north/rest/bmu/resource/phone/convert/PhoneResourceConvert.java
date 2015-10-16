package com.huawei.esdk.uc.north.rest.bmu.resource.phone.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.uc.domain.model.bean.PhoneInfo;
import com.huawei.esdk.uc.domain.model.bean.PhoneStateList;
import com.huawei.esdk.uc.north.rest.bean.PhoneState;

public class PhoneResourceConvert
{
    public List<PhoneInfo> queryPhoneStateRest2Model(List<com.huawei.esdk.uc.north.rest.bean.PhoneInfo> phoneList)
    {
        List<PhoneInfo> pInfoList = new ArrayList<PhoneInfo>();
        PhoneInfo pInfo = null;
        
        for (com.huawei.esdk.uc.north.rest.bean.PhoneInfo phoneInfo : phoneList)
        {
            pInfo = new PhoneInfo();
            pInfo.setGwIp(phoneInfo.getGwIp());
            pInfo.setNumber(phoneInfo.getNumber());
            pInfo.setSubPbx(phoneInfo.getSubPbx());
            pInfoList.add(pInfo);
        }
        
        return pInfoList;
    }
    
    public List<PhoneState> queryPhoneStateModel2Rest(PhoneStateList phoneStateList)
    {
        if (null == phoneStateList || null == phoneStateList.getPhoneStateList()
            || phoneStateList.getPhoneStateList().isEmpty())
        {
            return null;
        }
        
        List<PhoneState> list = new ArrayList<PhoneState>();
        PhoneState state = null;
        
        for (com.huawei.esdk.uc.domain.model.bean.PhoneState phoneState : phoneStateList.getPhoneStateList())
        {
            state = new PhoneState();
            state.setGwIp(phoneState.getGwIp());
            state.setNumber(phoneState.getNumber());
            state.setState(phoneState.getState());
            state.setSubPbx(phoneState.getSubPbx());
            list.add(state);
        }
        
        return list;
    }
}
