package com.huawei.esdk.uc.business.professional.rest.ctc.callback;

import com.huawei.esdk.platform.callback.CallbackBase;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;
import com.huawei.esdk.uc.northcommu.rest.callback.RestCTCListener;

public class RestNotifyCTCCallback extends CallbackBase implements ICallback
{
    public RestNotifyCTCCallback(String url)
    {
        NotifyDispatcher<RestCTCListener> notifyDispatcher = new RestCTCNotifyDispatcher();
        RestCTCListener clientListener = new RestCTCListener(url);
        notifyDispatcher.registerListener(clientListener);
        super.setNotifyDispatcher(notifyDispatcher);
    }

}
