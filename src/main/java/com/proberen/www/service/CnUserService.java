package com.proberen.www.service;

import com.proberen.www.entity.CnUser;
import com.proberen.www.util.ResultData;

public interface CnUserService {
    public ResultData<CnUser> findByUser(String userName,String passWord);
}
