package com.ert.library_management_system.repository;

import com.ert.library_management_system.config.HibernateUtils;
import com.ert.library_management_system.domain.Books;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {

  private Session session;

    public void save(Books books) {

        try {
            session= HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(books);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }


    }

    public Books findById(Long bookId) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            return session.get(Books.class,bookId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Books deleteBook) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.delete(deleteBook);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<Books> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("FROM Books", Books.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
return null;

    }

    public void update(Books books) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.update(books);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }


    }
}
