package com.luke.mock.service;

import com.luke.mock.bean.User;
import com.luke.mock.dao.UserDao;

/**
 * @author 廖水生
 * @date 2021/3/20 22:12
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void queryUserCount(User user) {
        userDao.save(user);
    }

}
