package dao;

import interfaces.UserDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sesFact;

    public UserHibernateDAO(SessionFactory sf) {
        this.sesFact = sf;
    }

    @Override
    public List<User> getAllUsers() {
        Session ses = sesFact.openSession();
        Transaction trx = ses.beginTransaction();
        List<User> usrs = ses.createQuery("From User").list();
        trx.commit();
        ses.close();
        return usrs;
    }

    @Override
    public boolean addUser(User user) {
        Session ses = sesFact.openSession();
        Transaction trx = ses.beginTransaction();
        ses.save(user);
        trx.commit();
        ses.close();
        return true;
    }

    @Override
    public boolean updateUserzData(User user) {
        Session session = sesFact.openSession();
        Transaction trx = session.beginTransaction();
        User fu = getUserBySsn(user);
        fu.setAge(user.getAge());
        fu.setEmail(user.getEmail());
        fu.setName(user.getName());
        fu.setSex(user.getSex());
        session.update(fu);
        trx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteUser(String ssn) {
        Session session = sesFact.openSession();
        Transaction trx = session.getTransaction();
        trx.begin();
        session.delete(getUserBySsn(ssn));
        trx.commit();
        session.close();
        return true;
    }


    private User getUserBySsn(User user) {
        Session session = sesFact.openSession();
        Transaction transaction = session.beginTransaction();
        User smUsr = null;
        Query query = (Query) session.getEntityManagerFactory().createEntityManager().createQuery("from User u where u.ssn = :ssn");
        query.setParameter("ssn", user.getSsn());
        smUsr = (User) query.getResultList().get(0);
        transaction.commit();
        session.close();
        return smUsr;
    }

    private User getUserBySsn(String ssn) {
        Session session = sesFact.openSession();
        Transaction transaction = session.beginTransaction();
        User smUsr = null;
        Query query = (Query) session.getEntityManagerFactory().createEntityManager().createQuery("from User u where u.ssn = :ssn");
        query.setParameter("ssn", ssn);
        smUsr = (User) query.getResultList().get(0);
        transaction.commit();
        session.close();
        return smUsr;
    }

}
