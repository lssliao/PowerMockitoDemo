package com.luke.mock.service;

import com.luke.mock.bean.User;
import com.luke.mock.dao.LocalUserDao;
import com.luke.mock.dao.UserDao;

/**
 * @author 廖水生
 * @date 2021/3/20 22:12
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {
        //ccc

    }


    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);
    }

    public int localQueryUserCount() {
        LocalUserDao localUserDao = new LocalUserDao();
        return localUserDao.getCount();
    }

    public void localSaveUser(User user) {
        LocalUserDao localUserDao = new LocalUserDao();
        localUserDao.insertUser(user);
    }

}
