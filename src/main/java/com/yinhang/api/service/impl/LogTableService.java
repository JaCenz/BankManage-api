package com.yinhang.api.service.impl;

import com.yinhang.api.entity.LogTable;
import com.yinhang.api.entity.LogTableExample;
import com.yinhang.api.mapper.LogTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/17 12:12
 */
@Service
public class LogTableService {

    @Autowired
    private LogTableMapper logTableMapper;

    public List getAllLogTable(){
        LogTableExample example = new LogTableExample();
        LogTableExample.Criteria criteria = example.createCriteria();
        List<LogTable> logTableList = logTableMapper.selectByExample(example);
        return logTableList.size() > 0 ? logTableList : null;
    }
}
