package com.luke.mock.dao;

import com.luke.mock.bean.User;

/**
 * @author 廖水生
 * @date 2021/3/20 22:11
 */
public class UserDao {
    public boolean save(User user) {
        System.out.println("--save--");
        throw new UnsupportedOperationException();
    }


    public boolean update(User user) {
        System.out.println("--update--");
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        System.out.println("--getCount--");
        throw new UnsupportedOperationException();
    }

}
