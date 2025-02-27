package com.proberen.www.dao;

import com.proberen.www.entity.CnShare;
import org.springframework.stereotype.Repository;

@Repository("cnShareDao")
public interface CnShareDaoMapper{
    public void saveShare(CnShare cnShare);

}
