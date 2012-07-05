package com.thoughtworks.go.sample.persistance;

import com.thoughtworks.go.sample.models.Book;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class BooksRepository extends HibernateDaoSupport {

    public BooksRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void save(Book book) {
        getHibernateTemplate().save(book);
    }

    public List<Book> allBooks() {
        return getHibernateTemplate().find("from Book");
    }
}
