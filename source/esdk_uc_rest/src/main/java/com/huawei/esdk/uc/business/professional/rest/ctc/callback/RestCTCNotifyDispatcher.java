package com.huawei.esdk.uc.business.professional.rest.ctc.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.notification.NotifyDispatcher;
import com.huawei.esdk.uc.domain.model.callback.CeeStatus;
import com.huawei.esdk.uc.domain.model.callback.ConfInfo;
import com.huawei.esdk.uc.domain.model.callback.ConfStatus;
import com.huawei.esdk.uc.northcommu.rest.callback.RestCTCListener;

/**
 * CTC通知分发类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C20]
 */
public class RestCTCNotifyDispatcher extends NotifyDispatcher<RestCTCListener>
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(RestCTCNotifyDispatcher.class);
    
    @Override
    public boolean notifyToOneListener(RestCTCListener listener, String ntfId, Object msg, Object additionalInfo)
    {
        if ("ctcuserstate".equals(ntfId))
        {
        	CeeStatus status = (CeeStatus)msg;
            listener.notifyConfCeeState(status.getConfId(), status.getCee(), status.getStatus());
        }
        else if ("ctcconferstate".equals(ntfId))
        {
        	ConfStatus status = (ConfStatus)msg;
            listener.notifyConfState(status.getConfId(), status.getStatus());
        }
        else if ("ctcconfinfo".equals(ntfId))
        {
        	ConfInfo confInfo = (ConfInfo)msg;
        	listener.notifyConfInfo(confInfo);
        }
        else
        {
            LOGGER.debug("RestCTCNotifyDispatcher notifyToOneListener error!");
        }
        
        return true;
    }
    
}
