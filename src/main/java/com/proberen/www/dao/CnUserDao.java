package com.proberen.www.dao;

import com.proberen.www.entity.CnUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CnUserDao {
    public List<CnUser> findAll();
}
