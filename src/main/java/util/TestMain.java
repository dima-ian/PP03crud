package util;

import dao.UserHibernateDAO;
import model.User;

public class TestMain {

    public static void main(String[] args) {

        System.out.println(HiberConnector.getSessionFactory());

        UserHibernateDAO uhd = new UserHibernateDAO(HiberConnector.getSessionFactory());

        System.out.println(uhd.getAllUsers());

        User usr = new User();


    }

}
