package com.huawei.esdk.uc.north.rest.bean;

public class SIPQueryRequest
{
    /**
     * 添加号码用户
     */
    private String userId;
    
    private String exactSearch;
    
    private String type;
    
    private String value;
    
    private String pageCount;
    
    private String pageNum;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getExactSearch()
    {
        return exactSearch;
    }
    
    public void setExactSearch(String exactSearch)
    {
        this.exactSearch = exactSearch;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    public String getPageCount()
    {
        return pageCount;
    }
    
    public void setPageCount(String pageCount)
    {
        this.pageCount = pageCount;
    }
    
    public String getPageNum()
    {
        return pageNum;
    }
    
    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }
    
}
