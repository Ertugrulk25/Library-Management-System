package com.ert.library_management_system.config;

import com.ert.library_management_system.domain.Books;
import com.ert.library_management_system.domain.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure().
                    addAnnotatedClass(Books.class).
                    addAnnotatedClass(Student.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutDown() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
    public static void closeSession(Session session){
        session.close();
    }
}
