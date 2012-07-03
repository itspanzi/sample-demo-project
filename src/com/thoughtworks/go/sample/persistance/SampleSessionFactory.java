package com.thoughtworks.go.sample.persistance;

import org.hibernate.SessionFactory;

public class SampleSessionFactory {
    private SessionFactory sessionFactory;

    public SampleSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return null;
    }
}
