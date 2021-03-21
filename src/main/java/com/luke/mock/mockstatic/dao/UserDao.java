package com.luke.mock.mockstatic.dao;

import com.luke.mock.bean.User;

/**
 * @author 廖水生
 * @date 2021/3/20 22:11
 */
public class UserDao {
    public static void insertUser(User user) {
        System.out.println("--static save--");
        throw new UnsupportedOperationException();
    }

    public static int getCount() {
        System.out.println("--static getCount--");
        throw new UnsupportedOperationException();
    }

}