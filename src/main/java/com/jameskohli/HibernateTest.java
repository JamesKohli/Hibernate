package com.jameskohli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by James on 9/16/2014.
 */
public class HibernateTest {

    public static void main(String[] args){
        User userDetails = new User();
        userDetails.setUserId(1);
        userDetails.setUserName("James Kohli");
        userDetails.setAddress("27 Chestnut St");
        userDetails.setJoinedDate(new Date());
        userDetails.setDescription("Me!");

        //Fire up hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
    }
}
