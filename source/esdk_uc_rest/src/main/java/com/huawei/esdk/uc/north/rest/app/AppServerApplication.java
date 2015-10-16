package com.huawei.esdk.uc.north.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.huawei.esdk.uc.north.rest.app.resource.affiche.AfficheResource;
import com.huawei.esdk.uc.north.rest.app.resource.callback.CallbackResource;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCAttendeeResource;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCResource;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCTerminalType;
import com.huawei.esdk.uc.north.rest.app.resource.ctc.CTCUpgrade;
import com.huawei.esdk.uc.north.rest.app.resource.ctd.CTDResource;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.AddressResource;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.EmployeeResource;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.EnterpriseResource;
import com.huawei.esdk.uc.north.rest.app.resource.userprofile.PersonInfoResource;


public class AppServerApplication extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(CTDResource.class);
        set.add(CTCResource.class);
        set.add(CTCAttendeeResource.class);
        set.add(CTCTerminalType.class);
        set.add(CTCUpgrade.class);
        set.add(AfficheResource.class);
        set.add(AddressResource.class);
        set.add(PersonInfoResource.class);
        set.add(EmployeeResource.class);
        set.add(EnterpriseResource.class);
        set.add(CallbackResource.class);
        return set;
    }
    
}
