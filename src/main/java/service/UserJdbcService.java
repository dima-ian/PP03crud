package service;

import dao.UserJdbcDAO;
import interfaces.UserDAO;
import model.User;
import util.DBHelper;

import java.util.List;

public class UserJdbcService implements UserDAO {

    public UserJdbcService() {  }

    public boolean addUser(User user)  {
        try {
            UserJdbcDAO dao = getUserDAO();
            if (dao.validateUser(user.getSsn())) {
                return false;
            }
            else { dao.addUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateUserzData(User user) {
        try {
            if (user != null) {
                getUserDAO().updateUserzData(user);
                return true;
            } else {
               return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String ssn) {
        try {
            User usr = getUserDAO().getUserBySsn(ssn);
            if (usr != null) {
                getUserDAO().deleteUser(ssn);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserBySsn(String ssn) {
        try {
            return getUserDAO().getUserBySsn(ssn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validateUser(String ssn) {
        try {
            return getUserDAO().validateUser(ssn);
        } catch (Exception e) {
            return false;
        }
    }

    private static UserJdbcDAO getUserDAO() {
        return new UserJdbcDAO(DBHelper.getInstance().getMysqlConnection());
    }

}
