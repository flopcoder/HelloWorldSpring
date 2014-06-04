package com.flopcoder.service;

import com.flopcoder.dao.IUserDao;
import com.flopcoder.dao.UserDao;
import com.flopcoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Flop Coder on 6/1/14.
 */

@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao userDao;
    @Override
    public User getUserById(Integer id)
    {
        return userDao.getUserById(id);
    }

    public User save(User user)
    {
        user.setName("FlopCoder");
        user.setAddress("Bangladesh");
        user.setEmail("flopcoder.82@gmail.com");
        user.setMobile("01684398208");
        user.setPassword("secret");
        user.setUserName("flopcoder");
        return userDao.save(user);
    }

}
