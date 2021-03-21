package com.luke.mock.mockstatic.service;

import com.luke.mock.bean.User;
import com.luke.mock.mockstatic.dao.UserDao;

/**
 * @author 廖水生
 * @date 2021/3/21 17:37
 */
public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }

}
