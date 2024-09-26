package com.proberen.www.service.impl;

import com.proberen.www.dao.CnUserDaoMapper;
import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CnUserServiceImpl implements CnUserService {
    @Resource(name="cnUserDao")
    private CnUserDaoMapper cnUserDaoMapper;
    @Override
    public ResultData<CnUser> findByUser(String userName,String passWord)
    {
        ResultData<CnUser> resultData=new ResultData<CnUser>();
        resultData.setStaticCode(Status.SUCCESS);
        resultData.setMsg("Login ist erfolgreich!");
        Map<String,String> params=new HashMap<String,String>();
        params.put("userName",userName);
        params.put("passWord",passWord);
        CnUser cnuser=cnUserDaoMapper.findByName(params);
        resultData.setObjectData(cnuser);
        return resultData;
    }
}
