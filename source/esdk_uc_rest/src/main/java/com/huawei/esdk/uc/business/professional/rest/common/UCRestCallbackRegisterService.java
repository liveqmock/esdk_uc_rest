package com.huawei.esdk.uc.business.professional.rest.common;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;
import com.huawei.esdk.uc.base.UCNotifyCallback;
import com.huawei.esdk.uc.business.professional.rest.ctc.callback.RestNotifyCTCCallback;
import com.huawei.esdk.uc.domain.model.Notify;

public class UCRestCallbackRegisterService
{
	private static final Logger LOGGER = Logger.getLogger(UCRestCallbackRegisterService.class);

    private NotifyCollector notifyCollector;

//    private IDeviceManager deviceManager;

    private UCNotifyCallback ucNotifyCallback = new UCNotifyCallback();

    public SDKErrorCode register(Map<String, String> map)
    {
        String devId = ConfigManager.getInstance().getValue("esdk.uc_appserver_device");
        
        notifyCollector.subscribeNotify(devId, "_",
                ucNotifyCallback);

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if ("CTC".equalsIgnoreCase(entry.getKey()))
            {
                ICallback callback = new RestNotifyCTCCallback(entry.getValue());
                ucNotifyCallback.registerCallback("ctc", callback);
            }
            else
            {
                LOGGER.warn("UCRestCallbackRegisterService register ability error - " + entry.getKey() + " is not supported");
            }
        }
        SDKErrorCode result = new SDKErrorCode();
        try
        {
            result = new Notify().registerNotification(true);
        }
        catch (SDKException e)
        {
            LOGGER.debug("register eror!");
        }
        return result;
    }

    public SDKErrorCode unregister(List<String> modules)
    {
        // Unsubscribe until all modules are unsubscribed
        for (String module : modules)
        {
            ucNotifyCallback.unregisterCallback(module);
        }
        
        //TODO call south interface
        if (!ucNotifyCallback.hasRegisteredModule())
        {
            String devId = ConfigManager.getInstance().getValue("esdk.uc_appserver_device");
            notifyCollector.unsubscribeNotify(devId, "_");
        }
        
        SDKErrorCode result = new SDKErrorCode();
        try
        {
            result = new Notify().registerNotification(false);
        }
        catch (SDKException e)
        {
            LOGGER.debug("unregister eror!");
        }
        return result;
    }

    public NotifyCollector getNotifyCollector()
    {
        return notifyCollector;
    }

    public void setNotifyCollector(NotifyCollector notifyCollector)
    {
        this.notifyCollector = notifyCollector;
    }

//    public IDeviceManager getDeviceManager()
//    {
//        return deviceManager;
//    }
//
//    public void setDeviceManager(IDeviceManager deviceManager)
//    {
//        this.deviceManager = deviceManager;
//    }
}
