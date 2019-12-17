package com.yinhang.api.service;

import com.yinhang.api.entity.User;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 22:45
 */
public interface UserService {

    /**
     *
     */
    User getUserByUsername(String username);

    User getUserByUsernameAndPassword(String username,String password);

    boolean deleteUserByUsername(String username);

    User createUser(String username,String password);

}
