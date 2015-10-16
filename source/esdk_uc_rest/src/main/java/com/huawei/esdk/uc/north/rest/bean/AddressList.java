package com.huawei.esdk.uc.north.rest.bean;

import java.util.List;

public class AddressList
{
    
    /**
     * 搜索结果集中成员的总数
     */
    private String total;
    
    /**
     * 当前分页消息中成员的数量
     */
    private String sum;
    
    /**
     * 个人通讯录
     */
    private List<Address> addresses;
    
    public String getTotal()
    {
        return total;
    }
    
    public void setTotal(String total)
    {
        this.total = total;
    }
    
    public String getSum()
    {
        return sum;
    }
    
    public void setSum(String sum)
    {
        this.sum = sum;
    }
    
    public List<Address> getAddresses()
    {
        return addresses;
    }
    
    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }
    
}
