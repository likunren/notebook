package com.proberen.www.service.impl;

import com.proberen.www.dao.CnUserDaoMapper;
import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import com.proberen.www.util.Utils;
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
        Map<String,String> params=new HashMap<String,String>();
        params.put("userName",userName);
        params.put("passWord",passWord);
        CnUser cnUser=cnUserDaoMapper.findByName(userName);
        if(null!=cnUser){
            String pwd=cnUser.getCnUserPassword();
            if(passWord.equals(pwd)){
                resultData.setStatusCode(Status.SUCCESS);
                resultData.setMsg("Login ist erfolgreich!");
            }else{
                resultData.setStatusCode(Status.PASS_WORD_ERROR);
                resultData.setMsg("Login ist erfolglos, weil Password falsh ist.");
            }
        }else{
            resultData.setStatusCode(Status.USER_NAME_ERROR);
            resultData.setMsg("es gibt Keinen User in dieses System.");
        }
        resultData.setObjectData(cnUser);
        return resultData;
    }

    @Override
    public ResultData<CnUser> registUser(CnUser cnUser) {
        ResultData<CnUser> resultData=new ResultData<CnUser>();
        cnUser.setCnUserId(Utils.get_UUID());
        cnUserDaoMapper.addUser(cnUser);
        resultData.setStatusCode(Status.SUCCESS);
        resultData.setMsg("Anmeldung ist erfolgreich");
        resultData.setObjectData(null);
        return resultData;
    }
}
