package com.yinhang.api.service.impl;

import com.yinhang.api.entity.User;
import com.yinhang.api.entity.UserExample;
import com.yinhang.api.mapper.UserMapper;
import com.yinhang.api.service.UserService;
import com.yinhang.api.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        User user = getUserByUsername(username);
        if(user == null)
            return false;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        userMapper.deleteByExample(example);
        return true;
    }

    @Override
    public User createUser(String username, String password) {
        String id = RandomUtils.string("user-id","this is user id");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertSelective(user);
        return userMapper.selectByPrimaryKey(id);
    }
}
