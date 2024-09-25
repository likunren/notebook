package com.proberen.www.service.impl;

import com.proberen.www.dao.CnUserDaoMapper;
import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CnUserServiceImpl implements CnUserService {
    @Resource(name="cnUserDao")
    private CnUserDaoMapper cnUserDaoMapper;
    @Override
    public List<CnUser> findAllUser() {
        return cnUserDaoMapper.findAll();
    }
}
