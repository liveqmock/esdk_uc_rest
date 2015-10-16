package com.huawei.esdk.uc.north.rest.bmu.resource.dept.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.uc.north.rest.bean.QueryDepartmentInfo;
import com.huawei.esdk.uc.north.rest.bean.QueryDepartmentInfoList;

public class DepartmentResourceConvert
{
    public QueryDepartmentInfoList getQueryDepartmentModel2Rest(
        com.huawei.esdk.uc.domain.model.bean.QueryDepartmentInfoList response)
    {
        QueryDepartmentInfoList departmentInfoList = new QueryDepartmentInfoList();
        departmentInfoList.setAmount(String.valueOf(response.getAmount()));
        
        if (null != response.getDepartmentInfoList() && !response.getDepartmentInfoList().isEmpty())
        {
            List<QueryDepartmentInfo> departmentInfos = new ArrayList<QueryDepartmentInfo>();
            QueryDepartmentInfo departmentInfo = null;
            
            for (com.huawei.esdk.uc.domain.model.bean.QueryDepartmentInfo qdInfo : response.getDepartmentInfoList())
            {
                departmentInfo = new QueryDepartmentInfo();
                departmentInfo.setDepartmentId(qdInfo.getDepartmentId());
                departmentInfo.setDepartmentName(qdInfo.getDepartmentName());
                departmentInfo.setDepartmentNo(qdInfo.getDepartmentNo());
                departmentInfos.add(departmentInfo);
            }
            
            departmentInfoList.setDepartmentInfoList(departmentInfos);
        }
        
        return departmentInfoList;
    }
}
