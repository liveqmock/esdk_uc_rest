package com.huawei.esdk.uc.north.rest.bmu.resource.sip.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.uc.common.CipherUtilsRest;
import com.huawei.esdk.uc.common.ErrInfo;
import com.huawei.esdk.uc.domain.model.SIP;
import com.huawei.esdk.uc.domain.model.bean.Gateway;
import com.huawei.esdk.uc.domain.model.bean.GatewayList;
import com.huawei.esdk.uc.domain.model.bean.SIPAuth;
import com.huawei.esdk.uc.domain.model.bean.SIPCondition;
import com.huawei.esdk.uc.domain.model.bean.SIPList;
import com.huawei.esdk.uc.north.rest.bean.GatewayResponse;
import com.huawei.esdk.uc.north.rest.bean.SIPAccount;
import com.huawei.esdk.uc.north.rest.bean.SIPAccountResponse;
import com.huawei.esdk.uc.north.rest.bean.SIPBatchResponse;
import com.huawei.esdk.uc.north.rest.bean.SIPQueryRequest;
import com.huawei.esdk.uc.north.rest.bean.SIPQueryResponse;

public class SIPAccountConvert
{
    
    public SIP getSIPRest2Model(SIPAccount rest) throws SDKException
    {
        SIP model = new SIP();
        model.setAddPrefix(rest.getAddPrefix());
        model.setGwIp(rest.getGwIp());
        model.setJoint(rest.getJoint());
        model.setLocalGwIp(rest.getLocalGwIp());
        model.setLongNum(rest.getLongNum());
        model.setNumber(rest.getNumber());
        model.setRightLevel(rest.getRightLevel());
        model.setSipUe(rest.getSipUe());
        model.setSubPbx(rest.getSubPbx());
        model.setUeType(rest.getUeType());
        
        com.huawei.esdk.uc.north.rest.bean.SIPAuth sipAuth = rest.getSipAuth();
        if (null != sipAuth)
        {
            SIPAuth sipAuthModel = new SIPAuth();
            model.setSipAuth(sipAuthModel);
            
            sipAuthModel.setType(sipAuth.getType());
            
            // modify by cWX191990，不需要判断，如果为空字符会导致cxf发消息时少了该节点
            //if (!StringUtils.isEmpty(sipAuth.getIp()))
            //{
            sipAuthModel.setIp(sipAuth.getIp());
            //}
            
            String pas = "";
            if (!StringUtils.isEmpty(sipAuth.getPassword()))
            {
                pas = CipherUtilsRest.decodeFromBase64(sipAuth.getPassword());
                if (StringUtils.isEmpty(pas))
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                    throw sdkException;
                }
            }
            sipAuthModel.setPassword(pas);
        }
        
        return model;
    }
    
    public List<SIP> getSIPBatchRest2Model(List<SIPAccount> sips) throws SDKException
    {
        List<SIP> sipModels = new ArrayList<SIP>();
        
        for (SIPAccount sipRest : sips)
        {
            SIP sipModel = getSIPRest2Model(sipRest);
            sipModels.add(sipModel);
        }
        return sipModels;
    }
    
    public SIP getSIPPswRest2Model(SIPAccount rest) throws SDKException
    {
        SIP model = new SIP();
        model.setGwIp(rest.getGwIp());
        model.setSubPbx(rest.getSubPbx());
        model.setSipUe(rest.getSipUe());
        
        com.huawei.esdk.uc.north.rest.bean.SIPAuth sipAuth = rest.getSipAuth();
        if (null != sipAuth)
        {
            SIPAuth sipAuthModel = new SIPAuth();
            model.setSipAuth(sipAuthModel);
            
            sipAuthModel.setType(sipAuth.getType());
            
            // modify by cWX191990，不需要判断，如果为空字符会导致cxf发消息时少了该节点
            //if (!StringUtils.isEmpty(sipAuth.getOldIp()))
            //{
            sipAuthModel.setOldIp(sipAuth.getOldIp());
            //}
            //if (!StringUtils.isEmpty(sipAuth.getNewIp()))
            //{
            sipAuthModel.setNewIp(sipAuth.getNewIp());
            //}
            
            if (!StringUtils.isEmpty(sipAuth.getOldPassword()))
            {
                String oldPsw = CipherUtilsRest.decodeFromBase64(sipAuth.getOldPassword());
                if (StringUtils.isEmpty(oldPsw))
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                    throw sdkException;
                }
                sipAuthModel.setOldPassword(oldPsw);
            }
            else
            {
                sipAuthModel.setOldPassword(sipAuth.getOldPassword());
            }
            
            if (!StringUtils.isEmpty(sipAuth.getNewPassword()))
            {
                String newPsw = CipherUtilsRest.decodeFromBase64(sipAuth.getNewPassword());
                if (StringUtils.isEmpty(newPsw))
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                    throw sdkException;
                }
                sipAuthModel.setNewPassword(newPsw);
            }
            else
            {
                sipAuthModel.setNewPassword(sipAuth.getNewPassword());
            }
        }
        
        return model;
    }
    
    public SIP getDeleteSipRest2Model(SIPAccount rest)
    {
        SIP model = new SIP();
        model.setGwIp(rest.getGwIp());
        model.setSubPbx(rest.getSubPbx());
        model.setDeleteSipUe(rest.getDeleteSipUe());
        // 产品需要使用sipUe 20140709
        //model.setNumber(rest.getNumber());
        model.setSipUe(rest.getSipUe());
        
        return model;
    }
    
    public List<SIP> getBatchDelSipRest2Model(List<SIPAccount> sips)
    {
        List<SIP> sipModels = new ArrayList<SIP>();
        
        for (SIPAccount sipRest : sips)
        {
            SIP sipModel = getDeleteSipRest2Model(sipRest);
            sipModels.add(sipModel);
        }
        return sipModels;
    }
    
    public SIPCondition getQuerySipRest2Model(SIPQueryRequest sip)
    {
        SIPCondition con = new SIPCondition();
        con.setExactsearch(sip.getExactSearch());
        con.setType(sip.getType());
        con.setValue(sip.getValue());
        con.setPagecount(sip.getPageCount());
        con.setPagenum(sip.getPageNum());
        return con;
    }
    
    public SIPQueryResponse getQuerySipModel2Rest(SDKResult<SIPList> result) throws SDKException
    {
        SIPQueryResponse response = new SIPQueryResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        SIPList modelList = result.getResult();
        if (null != modelList)
        {
            com.huawei.esdk.uc.north.rest.bean.SIPList restList = new com.huawei.esdk.uc.north.rest.bean.SIPList();
            response.setSipList(restList);
            restList.setAmount(String.valueOf(modelList.getAmount()));
            
            List<SIP> sips = modelList.getSips();
            if (null != sips && !sips.isEmpty())
            {
                //DTS2014070819311，modify by cWX191990，北向转换多了几个password字段
                List<SIPAccountResponse> sipRests = new ArrayList<SIPAccountResponse>();
                restList.setSips(sipRests);
                SIPAccountResponse rest = null;
                for (SIP sip : sips)
                {
                    rest = new SIPAccountResponse();
                    sipRests.add(rest);
                    rest.setGwIp(sip.getGwIp());
                    rest.setSubPbx(sip.getSubPbx());
                    rest.setLocalGwIp(sip.getLocalGwIp());
                    rest.setJoint(sip.getJoint());
                    rest.setSipUe(sip.getSipUe());
                    rest.setUeType(sip.getUeType());
                    rest.setNumber(sip.getNumber());
                    rest.setLongNum(sip.getLongNum());
                    rest.setRightLevel(sip.getRightLevel());
                    
                    SIPAuth authModel = sip.getSipAuth();
                    if (null != authModel)
                    {
                        // DTS2014070819311，modify by cWX191990，北向转换多了几个password字段
//                        com.huawei.esdk.uc.north.rest.bean.SIPAuth auth =
//                            new com.huawei.esdk.uc.north.rest.bean.SIPAuth();
                        com.huawei.esdk.uc.north.rest.bean.SIPAuthResponse auth =
                            new com.huawei.esdk.uc.north.rest.bean.SIPAuthResponse();
                        rest.setSipAuth(auth);
                        
                        auth.setType(authModel.getType());
                        if (!StringUtils.isEmpty(authModel.getPassword()))
                        {
                            String password = null;
                            try
                            {
                                password = CipherUtilsRest.encode(authModel.getPassword());
                            }
                            catch (SDKException e)
                            {
                                throw e;
                            }
                            if (StringUtils.isEmpty(password))
                            {
                                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                                throw sdkException;
                            }
                            auth.setPassword(password);
                        }
                        else
                        {
                            auth.setPassword(authModel.getPassword());
                        }
                        auth.setIp(authModel.getIp());
                    }
                }
                
            }
            
        }
        return response;
    }
    
    public SIPBatchResponse getBatchDeleteSipModel2Rest(SDKResult<SIPList> result)
    {
        SIPBatchResponse response = new SIPBatchResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        SIPList modelList = result.getResult();
        if (null != modelList)
        {
            com.huawei.esdk.uc.north.rest.bean.SIPBatchList restList =
                new com.huawei.esdk.uc.north.rest.bean.SIPBatchList();
            response.setSipList(restList);
            restList.setAmount(String.valueOf(modelList.getAmount()));
            
            List<SIP> sips = modelList.getSips();
            if (null != sips && !sips.isEmpty())
            {
                List<com.huawei.esdk.uc.north.rest.bean.SIPBatchAccountRes> sipRests =
                    new ArrayList<com.huawei.esdk.uc.north.rest.bean.SIPBatchAccountRes>();
                restList.setSips(sipRests);
                com.huawei.esdk.uc.north.rest.bean.SIPBatchAccountRes rest = null;
                for (SIP sip : sips)
                {
                    rest = new com.huawei.esdk.uc.north.rest.bean.SIPBatchAccountRes();
                    sipRests.add(rest);
                    rest.setGwIp(sip.getGwIp());
                    rest.setSubPbx(sip.getSubPbx());
                    rest.setNumber(sip.getNumber());
                }
            }
        }
        
        return response;
    }
    
    public GatewayResponse getGatewayMode2Rest(SDKResult<GatewayList> result)
    {
        GatewayResponse response = new GatewayResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(StringUtils.avoidNull(result.getDescription()));
        
        GatewayList modelList = result.getResult();
        if (null != modelList)
        {
            com.huawei.esdk.uc.north.rest.bean.GatewayList gatewayList =
                new com.huawei.esdk.uc.north.rest.bean.GatewayList();
            response.setGatewayList(gatewayList);
            gatewayList.setAmount(modelList.getAmount());
            
            List<Gateway> gatewayModels = modelList.getGateways();
            if (null != gatewayModels && !gatewayModels.isEmpty())
            {
                List<com.huawei.esdk.uc.north.rest.bean.Gateway> gateways =
                    new ArrayList<com.huawei.esdk.uc.north.rest.bean.Gateway>();
                gatewayList.setGateways(gateways);
                com.huawei.esdk.uc.north.rest.bean.Gateway gateway = null;
                for (Gateway model : gatewayModels)
                {
                    gateway = new com.huawei.esdk.uc.north.rest.bean.Gateway();
                    gateways.add(gateway);
                    gateway.setGwIp(model.getGwIp());
                    gateway.setState(model.getState());
                    gateway.setSubPbxs(model.getSubPbxs());
                }
            }
        }
        
        return response;
    }
    
}
