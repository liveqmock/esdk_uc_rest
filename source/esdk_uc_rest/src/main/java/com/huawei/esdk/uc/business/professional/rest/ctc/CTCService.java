package com.huawei.esdk.uc.business.professional.rest.ctc;

import java.util.List;

import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.Conference;
import com.huawei.esdk.uc.domain.model.HoldingConference;
import com.huawei.esdk.uc.domain.model.Terminal;
import com.huawei.esdk.uc.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.uc.domain.model.bean.PagedList;
import com.huawei.esdk.uc.domain.model.bean.QueryMeetingParam;
import com.huawei.esdk.uc.domain.model.bean.TerminalInConfInfo;

public class CTCService
{
    public SDKResult<String> createConf(Conference conf)
        throws SDKException
    {
        SDKResult<String> result = new SDKResult<String>();
        if (null == conf)
        {
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        result = conf.createConfRest(conf);
        return result;
    }
    
    public SDKResult<List<Conference>> queryConf(String account)
        throws SDKException
    {
        return new Conference().getConfListRest(account, null, null, null, null, null);
    }
    
    public SDKErrorCode endConf(String account, String confId)
        throws SDKException
    {
        return new Conference(confId).releaseConfRest(account);
    }
    
    public SDKErrorCode addAttendee(Conference conf)
        throws SDKException
    {
        return conf.addIntoConfRest(conf.getInitiatorId(), conf.getSites());
    }
    
    public SDKErrorCode delAttendee(Conference conf)
        throws SDKException
    {
        return conf.delFromConfRest(conf.getInitiatorId(), conf.getSites());
    }
    
    public SDKErrorCode updateAttendee(String account, String confId, String cee, int auth)
        throws SDKException
    {
        return new Conference(confId).mdfyTalkModeRest(account, cee, auth);
    }
    
    public SDKErrorCode upgradeAudioToDataConf(String confId, String account)
        throws SDKException
    {
        SDKErrorCode sdkErrorCode = null;
        Conference conference = new Conference(confId);
        sdkErrorCode = conference.upgradeAudioToDataConfRest(account);
        return sdkErrorCode;
    }

    
    public SDKResult<HoldingConference> getConfInfo(String ucAccount, String confId)
        throws SDKException
    {
        if (null == ucAccount || null == confId)
        {
            SDKResult<HoldingConference> result = new SDKResult<HoldingConference>();
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        HoldingConference holdingConference = new HoldingConference(confId);
        return holdingConference.getConfInfo(ucAccount);
    }
    
    public SDKResult<TerminalInConfInfo> informTerminalType(String account, String confId)
        throws SDKException
    {
        Conference conference = new Conference(confId);
        SDKResult<TerminalInConfInfo> result =
            conference.informTerminalTypeRest(account, null, null, null);
        
        return result;
    }

    public SDKResult<List<Terminal>> getAttendee(String confId)
        throws SDKException
    {
        return new Conference().queryAttendeesRest(confId);
    }

    /**
     * 
     * BMU接口
     * 预约会议
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    
    public SDKResult<String> scheduleMeeting(Conference conf) throws SDKException
    {
        SDKResult<String> result = new SDKResult<String>();
        if (null == conf)
        {
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }

        return conf.scheduleMeeting(conf);
    }
    
    /**
     * 
     * BMU接口
     * 修改会议
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKErrorCode modifyMeeting(Conference conf) throws SDKException
    {
        SDKErrorCode result = new SDKErrorCode();
        if (null == conf)
        {
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }

        return conf.modifyMeeting(conf);
    }
    
    /**
     * 
     * BMU接口
     * 批量删除会议
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<List<DeleteMeetingParam>> deleteMeeting(String userId, List<DeleteMeetingParam> params) throws SDKException
    {
        SDKResult<List<DeleteMeetingParam>> result = 
            new SDKResult<List<DeleteMeetingParam>>();
        if (null == params || null == userId)
        {
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }

        return new Conference().deleteMeeting(userId, params);
    }
    
    /**
     * 
     * BMU接口
     * 查询会议
     * @param conf
     * @return
     * @throws SDKException
     * @see [类、类#方法、类#成员]
     * @since  [产品/模块版本]
     */
    public SDKResult<PagedList<Conference>> queryMeeting(QueryMeetingParam param) throws SDKException
    {
        SDKResult<PagedList<Conference>> result = new SDKResult<PagedList<Conference>>();
        if (null == param)
        {
            result.setErrCode(ErrInfo.SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }

        return new Conference().queryMeeting(param);
    }
}
