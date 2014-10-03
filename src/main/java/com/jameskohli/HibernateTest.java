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


        //Saving another object in a class
        Address address = new Address();
        address.setCity("New York");
        address.setState("NY");
        address.setStreet("Main St");
        address.setZip("10016");

        Address address2 = new Address();
        address2.setCity("Boston");
        address2.setState("MA");
        address2.setStreet("Main St");
        address2.setZip("02483");

        userDetails.getAddresses().add(address);
        userDetails.getAddresses().add(address2);

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
