package com.thoughtworks.go.sample.persistance;

import com.thoughtworks.go.sample.models.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserRepository extends HibernateDaoSupport {

    public UserRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public User save(User user) {
        return null;
    }
}
