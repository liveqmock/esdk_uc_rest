package com.huawei.esdk.uc.business.professional.rest.affiche;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.domain.model.Affiche;

public class AfficheService
{
    
    public SDKErrorCode sendAffiche(Affiche affiche)
        throws SDKException
    {
        return affiche.sendAfficheRest(affiche);
    }
    
}
