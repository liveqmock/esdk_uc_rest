package com.huawei.esdk.uc.north.rest.bmu.resource.attendee.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.uc.domain.model.Attendee;
import com.huawei.esdk.uc.domain.model.bean.DelAttendeeFailedList;
import com.huawei.esdk.uc.domain.model.bean.DelAttendeeInfo;
import com.huawei.esdk.uc.domain.model.bean.DelAttendeeInfoList;
import com.huawei.esdk.uc.north.rest.bean.AttendeeRequest;
import com.huawei.esdk.uc.north.rest.bean.DelAttendeeFailedInfo;
import com.huawei.esdk.uc.north.rest.bean.DelAttendeeRequest;
import com.huawei.esdk.uc.north.rest.bean.QueryAttendeeInfo;
import com.huawei.esdk.uc.north.rest.bean.QueryAttendeeInfoList;

public class AttendeeResourceConvert
{
    public Attendee getAddAttendeeRest2Model(AttendeeRequest attendeeRequest)
    {
        Attendee attendee = new Attendee();
        attendee.setAccount(attendeeRequest.getAccount());
        attendee.setAttNumber(attendeeRequest.getAttNumber());
        //attendee.setAttStatus(attendeeRequest.getAttStatus());
        attendee.setAttType(attendeeRequest.getAttType());
        attendee.setConfId(attendeeRequest.getConfId());
        attendee.setEmail(attendeeRequest.getEmail());
        attendee.setGwIp(attendeeRequest.getGwIp());
        //attendee.setSpeakStatus(attendeeRequest.getSpeakStatus());
        attendee.setSubPbx(attendeeRequest.getSubPbx());
        attendee.setUserId(attendeeRequest.getUserId());
        
        return attendee;
    }
    
    public QueryAttendeeInfoList getQueryAttendeeModel2Rest(
        com.huawei.esdk.uc.domain.model.bean.QueryAttendeeInfoList response)
    {
        QueryAttendeeInfoList attendeeInfoList = new QueryAttendeeInfoList();
        attendeeInfoList.setAmount(String.valueOf(response.getAmount()));
        
        if (null != response.getAttendeeInfoList() && !response.getAttendeeInfoList().isEmpty())
        {
            List<QueryAttendeeInfo> attendeeInfos = new ArrayList<QueryAttendeeInfo>();
            QueryAttendeeInfo attendeeInfo = null;
            
            for (com.huawei.esdk.uc.domain.model.bean.QueryAttendeeInfo info : response.getAttendeeInfoList())
            {
                attendeeInfo = new QueryAttendeeInfo();
                attendeeInfo.setAccount(info.getAccount());
                attendeeInfo.setAttNumber(info.getAttNumber());
                attendeeInfo.setAttStatus(info.getAttStatus());
                attendeeInfo.setAttType(info.getAttType());
                attendeeInfo.setConfId(info.getConfId());
                attendeeInfo.setEmail(info.getEmail());
                attendeeInfo.setGwIp(info.getGwIp());
                attendeeInfo.setDataUrl(info.getDataUrl());
                
                attendeeInfos.add(attendeeInfo);
            }
            
            attendeeInfoList.setAttendeeInfoList(attendeeInfos);
        }
        
        return attendeeInfoList;
    }
    
    public DelAttendeeInfoList getDeleteAttendeeRest2Model(DelAttendeeRequest request)
    {
        DelAttendeeInfoList attendeeInfoList = new DelAttendeeInfoList();
        attendeeInfoList.setUserId(request.getUserId());
        attendeeInfoList.setConfId(request.getConfId());
        attendeeInfoList.setGwIp(request.getGwIp());
        
        List<DelAttendeeInfo> list = new ArrayList<DelAttendeeInfo>();
        DelAttendeeInfo info = null;
        
        for (com.huawei.esdk.uc.north.rest.bean.DelAttendeeInfo daInfo : request.getAttendeeInfos())
        {
            info = new DelAttendeeInfo();
            info.setAccount(daInfo.getAccount());
            info.setAttNumber(daInfo.getAttNumber());
            list.add(info);
        }
        
        attendeeInfoList.setAttendeeInfos(list);
        
        return attendeeInfoList;
    }
    
    public List<DelAttendeeFailedInfo> getDeleteAttendeeModel2Rest(DelAttendeeFailedList delAttendeeFailedList)
    {
        List<DelAttendeeFailedInfo> attendeeFailedInfos = new ArrayList<DelAttendeeFailedInfo>();
        
        if (null != delAttendeeFailedList.getAttendeeFailedInfos()
            && !delAttendeeFailedList.getAttendeeFailedInfos().isEmpty())
        {
            DelAttendeeFailedInfo failedInfo = null;
            
            for (com.huawei.esdk.uc.domain.model.bean.DelAttendeeFailedInfo info : delAttendeeFailedList.getAttendeeFailedInfos())
            {
                failedInfo = new DelAttendeeFailedInfo();
                failedInfo.setAccount(info.getAccount());
                failedInfo.setAttNumber(info.getAttNumber());
                failedInfo.setFailedReason(info.getFailedReason());
                
                attendeeFailedInfos.add(failedInfo);
            }
        }
        
        return attendeeFailedInfos;
    }
    
    public Attendee getOperateAttendeeRest2Model(AttendeeRequest request)
    {
        Attendee attendee = new Attendee();
        attendee.setUserId(request.getUserId());
        attendee.setGwIp(request.getGwIp());
        attendee.setConfId(request.getConfId());
        attendee.setOperate(request.getOperate());
        attendee.setAttNumber(request.getAttNumber());
        attendee.setAttType(request.getAttType());
        attendee.setOperNumber(request.getOperNumber());
        
        return attendee;
    }
    
    public Attendee getTransferChairmanRest2Model(AttendeeRequest request)
    {
        Attendee attendee = new Attendee();
        attendee.setUserId(request.getUserId());
        attendee.setGwIp(request.getGwIp());
        attendee.setConfId(request.getConfId());
        attendee.setOldChairman(request.getOldChairman());
        attendee.setNewChairman(request.getNewChairman());
        
        return attendee;
    }
}
