package com.huawei.esdk.uc.north.rest.bmu.resource.userlevel.convert;

import java.util.ArrayList;
import java.util.List;
import com.huawei.esdk.uc.domain.model.UserLevel;
import com.huawei.esdk.uc.domain.model.bean.UserLevelInfo;
import com.huawei.esdk.uc.north.rest.bean.QueryUserLevelResponse;

public class UserLevelResourceConvert
{

    public QueryUserLevelResponse queryUserLevelModal2Rest(UserLevel result)
    {
        if(null == result)
        {
            return null;
        }
        QueryUserLevelResponse queryUserLevelInfoResponse = new QueryUserLevelResponse();
        queryUserLevelInfoResponse.setAmount(result.getCount());
        List<UserLevelInfo> userLevelsModal = result.getUserLevelInfos();
        if(null != userLevelsModal)
        {
            List<com.huawei.esdk.uc.north.rest.bean.UserLevelInfo> userLevelInfos = new 
                ArrayList<com.huawei.esdk.uc.north.rest.bean.UserLevelInfo>();
            for(UserLevelInfo roleModal : userLevelsModal)
            {
                com.huawei.esdk.uc.north.rest.bean.UserLevelInfo userLevel = 
                    new com.huawei.esdk.uc.north.rest.bean.UserLevelInfo();
                userLevel.setDescription(roleModal.getDescription());
                userLevel.setLevelId(roleModal.getLevelId());
                userLevel.setLevelName(roleModal.getLevelValue());
                userLevel.setLevelValue(roleModal.getLevelValue());
                userLevelInfos.add(userLevel);
            }
            queryUserLevelInfoResponse.setUserLevelInfos(userLevelInfos);
        }
        return queryUserLevelInfoResponse;
    }
    
}
