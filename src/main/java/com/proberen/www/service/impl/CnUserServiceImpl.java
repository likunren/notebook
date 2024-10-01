package com.proberen.www.service.impl;

import com.proberen.www.dao.CnUserDaoMapper;
import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import com.proberen.www.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CnUserServiceImpl implements CnUserService {
    @Resource(name="cnUserDao")
    private CnUserDaoMapper cnUserDaoMapper;
    @Transactional
    public ResultData<CnUser> findByUser(String userName,String passWord)
    {
        ResultData<CnUser> resultData=new ResultData<CnUser>();
        Map<String,String> params=new HashMap<String,String>();
        params.put("userName",userName);
        passWord=Utils.get_MD5(passWord);
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

   @Transactional
    public ResultData<CnUser> registUser(CnUser cnUser) {
        ResultData<CnUser> resultData=new ResultData<CnUser>();
        //is User existiert
        CnUser cnUserTemp=cnUserDaoMapper.findByName(cnUser.getCnUserName());
        if(null==cnUserTemp) {
            cnUser.setCnUserId(Utils.get_UUID());
            cnUser.setCnUserPassword(Utils.get_MD5(cnUser.getCnUserPassword()));
            cnUserDaoMapper.addUser(cnUser);
            resultData.setStatusCode(Status.SUCCESS);
            resultData.setMsg("Anmeldung ist erfolgreich.");
            resultData.setObjectData(null);
        }else{
            resultData.setStatusCode(Status.USER_EXIST);
            resultData.setMsg("User ist shon existiert.");
            resultData.setObjectData(null);
        }
        return resultData;
    }

}
