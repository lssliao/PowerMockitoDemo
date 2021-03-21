package com.luke.mock.service;

import com.luke.mock.bean.User;
import com.luke.mock.dao.LocalUserDao;
import com.luke.mock.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author 廖水生
 * @date 2021/3/20 22:18
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;


    @Before
    public void setUp() throws Exception {
        userService = new UserService(new UserDao());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testQueryUserCountWithPowerMock() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        UserService userService = new UserService(userDao);
        int result = userService.queryUserCount();
        assertThat(result, equalTo(10));
    }

    @Test
    public void testSaveUserWithPowerMock() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(userDao).insertUser(user);
        UserService userService = new UserService(userDao);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
//        assertThat(result, equalTo(10));
    }

    @Ignore
    @Test
    public void testQueryUserCountWithJunit() {
        try {
            userService.queryUserCount();
            fail("Should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Ignore
    @Test
    public void testSaveUserWithJunit() {
        try {
            userService.saveUser(new User());
            fail("Should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void testQueryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void testLocalQueryUserCount() {
        UserService userService = new UserService();
        LocalUserDao localUserDao = PowerMockito.mock(LocalUserDao.class);
        try {
            PowerMockito.whenNew(LocalUserDao.class).withNoArguments().thenReturn(localUserDao);
            PowerMockito.doReturn(10).when(localUserDao).getCount();
            int result = userService.localQueryUserCount();
            assertThat(result, equalTo(10));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testLocalSaveUser() throws Exception {
        UserService userService = new UserService();
        LocalUserDao localUserDao = PowerMockito.mock(LocalUserDao.class);
        User user = new User();
        try {
            PowerMockito.whenNew(LocalUserDao.class).withAnyArguments().thenReturn(localUserDao);
            PowerMockito.doNothing().when(localUserDao).insertUser(user);
            userService.localSaveUser(user);
            Mockito.verify(localUserDao, Mockito.times(1)).insertUser(user);
        } catch (Exception e) {
            fail();
        }
       /* PowerMockito.when(localUserDao.getCount()).thenAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                invocationOnMock.getMock()
                return null;
            }
        });
        PowerMockito.whenNew(UserDao.class).withArguments("xx", "xx");

        PowerMockito.spy()*/

    }
}