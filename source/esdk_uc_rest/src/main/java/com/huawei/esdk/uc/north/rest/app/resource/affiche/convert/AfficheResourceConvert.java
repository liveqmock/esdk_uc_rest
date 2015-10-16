package com.huawei.esdk.uc.north.rest.app.resource.affiche.convert;

import com.huawei.esdk.uc.domain.model.Affiche;
import com.huawei.esdk.uc.north.rest.bean.AfficheRequest;

public class AfficheResourceConvert
{

    public Affiche getAfficheRest2Model(AfficheRequest affiche)
    {
        Affiche model = new Affiche();
        model.setInitiatorId(affiche.getInitiatorId());
        model.setAfficheTitle(affiche.getAfficheTitle());
        model.setAfficheContent(affiche.getAfficheContent());
        model.setReceiverType(affiche.getReceiverType());
        
        if (null != affiche.getStaffAccounts() && !affiche.getStaffAccounts().isEmpty())
        {
            model.setStaffAccount(affiche.getStaffAccounts());
        }
        
        if (null != affiche.getDepartmentIds() && !affiche.getDepartmentIds().isEmpty())
        {
            model.setDepartmentId(affiche.getDepartmentIds());
        }
        
        return model;
    }
    
}
