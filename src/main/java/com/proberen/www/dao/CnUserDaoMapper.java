package com.proberen.www.dao;

import com.proberen.www.entity.CnUser;
import org.springframework.stereotype.Repository;

@Repository("cnUserDao")
public interface CnUserDaoMapper {
    public CnUser findByName(String userParams);
    public void addUser(CnUser cnUser);
}
