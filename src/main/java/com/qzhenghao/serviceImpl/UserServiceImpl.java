package com.qzhenghao.serviceImpl;

import com.qzhenghao.dao.UserDao;
import com.qzhenghao.entity.User;
import com.qzhenghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suiyue
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String usernumber) {
        User user = userDao.queryByUsernumber(usernumber);
        return user;
    }
    @Override
    public User queryById(long id) {
        User user = userDao.queryById(id);
        return user;
    }

    @Override
    public String register(String usernumber, String email, String name, String password, String tel) {
        String result = "fail";
        User user = userDao.queryByUsernumber(usernumber);
        if (user != null) {
            result = "usernumberExist";
        } else {
            User user1 = new User();
            user1.setUsernumber(usernumber);

            user1.setEmail(email);
            user1.setName(name);
            user1.setPassword(password);
            user1.setTel(tel);
            //默认学生
            user1.setType(3);
            int i = userDao.insertUser(user1);
            if (i != 0) {
                result = "success";
            }
        }

        return result;
    }

    @Override
    public List<User> queryAll() {
        List<User> userList=userDao.queryAll();
        return userList;
    }

    @Override
    public int deleteUser(long id) {
        int t = userDao.deleteUser(id);
        return t;
    }

    @Override
    public int insertUser(User user) {
        int t = userDao.insertUser(user);
        return t;
    }

    @Override
    public List<User> queryTopN() {
        List<User>userList =userDao.queryTopN();
        return userList;
    }

    @Override
    public List<User> findUserByProvince(String province) {
        List<User> userList = userDao.findUserByProvince(province);
        System.out.println(userList.toString());
        return userList;
    }
}
