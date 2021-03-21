package com.luke.mock.dao;

import com.luke.mock.bean.User;

/**
 * @author 廖水生
 * @date 2021/3/20 22:11
 */
public class LocalUserDao {
    public void insertUser(User user) {
        System.out.println("--Local save--");
        throw new UnsupportedOperationException();
    }


    public boolean update(User user) {
        System.out.println("-- Local update--");
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        System.out.println("--Local getCount--");
        throw new UnsupportedOperationException();
    }

}
