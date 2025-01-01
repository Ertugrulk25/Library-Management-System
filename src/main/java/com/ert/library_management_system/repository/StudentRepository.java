package com.ert.library_management_system.repository;

import com.ert.library_management_system.config.HibernateUtils;
import com.ert.library_management_system.domain.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRepository {
   private Session session;

    public void save(Student student) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(student);

            trs.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }


    }

    public void delete(Student student) {

        try {
            session= HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.delete(student);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }


    }

    public Student findById(Long deleteStudentWithId) {

        try {
            session=HibernateUtils.getSessionFactory().openSession();
            Student student = session.get(Student.class,deleteStudentWithId);

          return student;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
return null;
    }

    public void update(Student student) {

        try {
            session= HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.update(student);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
