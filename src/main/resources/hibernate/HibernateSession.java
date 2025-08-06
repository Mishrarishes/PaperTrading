package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Student;

public class HibernateSession {
  public static void main(String[] args){
    // Create a SessionFactory
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
  }
}


