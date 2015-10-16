package com.huawei.esdk.uc.north.rest.bean;


public class QueryAddressResponse
{
    private String resultCode;
    
    private String resultContext;
    
    private AddressList addressList;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultContext()
    {
        return resultContext;
    }
    
    public void setResultContext(String resultContext)
    {
        this.resultContext = resultContext;
    }
    
    public AddressList getAddressList()
    {
        return addressList;
    }
    
    public void setAddressList(AddressList addressList)
    {
        this.addressList = addressList;
    }
    
}
