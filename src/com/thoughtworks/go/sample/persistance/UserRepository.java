package com.thoughtworks.go.sample.persistance;

import com.thoughtworks.go.sample.models.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserRepository extends HibernateDaoSupport {

    public UserRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    public List<User> allUsers() {
        return getHibernateTemplate().find("from User");
    }
}
