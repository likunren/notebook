package com.proberen.www.service.impl;

import com.proberen.www.dao.CnUserDao;
import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CnUserServiceImpl implements CnUserService {
    @Resource(name="cnUserDao")
    private CnUserDao cnUserDao;
    @Override
    public List<CnUser> findAllUser() {
        return cnUserDao.findAll();
    }
}
