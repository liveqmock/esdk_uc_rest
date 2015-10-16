package com.huawei.esdk.uc.north.rest.bmu.resource.role.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.uc.domain.model.Role;
import com.huawei.esdk.uc.domain.model.bean.RoleInfo;
import com.huawei.esdk.uc.north.rest.bean.QueryRoleInfoResponse;

public class RoleResourceConvert
{

    public QueryRoleInfoResponse queryRoleModal2Rest(Role result)
    {
        if(null == result)
        {
            return null;
        }
        QueryRoleInfoResponse queryRoleInfoResponse = new QueryRoleInfoResponse();
        queryRoleInfoResponse.setAmount(result.getAmount());
        List<RoleInfo> rolesModal = result.getRoleInfos();
        if(null != rolesModal)
        {
            List<com.huawei.esdk.uc.north.rest.bean.RoleInfo> roleInfos = new 
                ArrayList<com.huawei.esdk.uc.north.rest.bean.RoleInfo>();
            for(RoleInfo roleModal : rolesModal)
            {
                com.huawei.esdk.uc.north.rest.bean.RoleInfo role = 
                    new com.huawei.esdk.uc.north.rest.bean.RoleInfo();
                role.setDescription(roleModal.getDescription());
                role.setRoleId(roleModal.getRoleId());
                role.setRoleName(roleModal.getRoleName());
                role.setRoleType(roleModal.getRoleType());
                roleInfos.add(role);
            }
            queryRoleInfoResponse.setRoleInfos(roleInfos);
        }
        return queryRoleInfoResponse;
    }
    
}