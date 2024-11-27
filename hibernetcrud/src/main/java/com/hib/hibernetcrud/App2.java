package com.hib.hibernetcrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Student;

public class App2 {
	public static void main( String[] args ) {
        SessionFactory factory = new Configuration().
        						configure("hibernate.cfg.xml").
        						addAnnotatedClass(Student.class).
        						buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student s=(Student)session.get(Student.class,2);//Fetch data from DB.
        System.out.println(s);
        session.getTransaction().commit();
    }
}
