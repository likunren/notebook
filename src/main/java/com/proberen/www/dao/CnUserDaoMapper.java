package com.proberen.www.dao;

import com.proberen.www.entity.CnUser;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("cnUserDao")
public interface CnUserDaoMapper {
    public List<CnUser> findAll();
}
