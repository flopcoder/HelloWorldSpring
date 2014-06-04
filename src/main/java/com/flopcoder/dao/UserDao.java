package com.flopcoder.dao;

import com.flopcoder.model.User;
import com.flopcoder.utils.DbUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Flop Coder on 6/1/14.
 */
@Repository
public class UserDao implements IUserDao{

    @Override
    public User getUserById(Integer id) {
        User user = read(id);
        return user;
    }

    @Override
    public User save(User user) {

        SessionFactory sessionFactory = DbUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(user);
        user.setId(id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    private static User read(Integer id) {
        SessionFactory sf = DbUtils.getSessionFactory();
        Session session = sf.openSession();

        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }
}
