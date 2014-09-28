package com.jameskohli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by James on 9/16/2014.
 */
public class HibernateTest {

    private static final Logger logger = LoggerFactory.getLogger(HibernateTest.class);

    public static void main(String[] args){
        User userDetails = new User();
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
        session.close();

        userDetails = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (User) session.get(User.class, 1);
        logger.info("Got user 1 with name " + userDetails.getUserName());
    }
}
