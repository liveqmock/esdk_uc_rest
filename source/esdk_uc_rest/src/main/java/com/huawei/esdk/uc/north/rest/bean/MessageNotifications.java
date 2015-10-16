package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class MessageNotifications
{
    private List<MessageNotification> callbackUrls;

    public List<MessageNotification> getCallbackUrls()
    {
    	return callbackUrls;
    }

    public void setCallbackUrls(List<MessageNotification> callbackUrls)
    {
    	this.callbackUrls = callbackUrls;
    }
}
