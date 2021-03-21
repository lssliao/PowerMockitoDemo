package com.luke.mock.mockstatic.service;

import com.luke.mock.bean.User;
import com.luke.mock.mockstatic.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author 廖水生
 * @date 2021/3/21 17:42
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDao.class, UserService.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int i = userService.queryUserCount();
        assertThat(i, equalTo(10));
    }

    @Test
    public void saveUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(user);
//        PowerMockito.verifyStatic(UserDao.class);
   

    }
}