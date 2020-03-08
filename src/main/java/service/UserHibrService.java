package service;

import dao.UserDaoFactory;
import dao.UserHibernateDAO;
import dao.UserDAO;
import model.User;

import java.util.List;

public class UserHibrService implements UserDAO {

    private UserHibrService() {  }

    private static UserHibrService usrHbrSrv;

    public static UserHibrService getInstance() {
        if (usrHbrSrv == null) {
            usrHbrSrv = new UserHibrService();
        }
        return usrHbrSrv;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return getUserHiber().getAllUsers();
        } catch (Exception x) {
            x.printStackTrace(); return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        try {
            getUserHiber().addUser(user);
            return true;
        } catch (Exception x) {
            x.printStackTrace(); return false;
        }
    }

    @Override
    public boolean updateUserzData(User user) {
        try {
            getUserHiber().updateUserzData(user);
            return true;
        } catch (Exception x) {
            x.printStackTrace(); return false;
        }
    }

    @Override
    public boolean deleteUser(String ssn) {
        try {
            getUserHiber().deleteUser(ssn);
            return true;
        } catch (Exception x) {
            x.printStackTrace(); return false;
        }
    }

    public User getUserByEmail(String email) {
        try {
            return getUserHiber().getUserByEmail(email);
        } catch (Exception x) {
            x.printStackTrace(); return null;
        }
    }

    public User getUserBySsn(String ssn) {
        try {
            return getUserHiber().getUserBySsn(ssn);
        } catch (Exception x) {
            x.printStackTrace(); return null;
        }
    }

    private static UserHibernateDAO getUserHiber() { return (UserHibernateDAO) UserDaoFactory.getConnectionDAO();  }

}
