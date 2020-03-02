package dao;

import interfaces.UserDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;
import util.PropsGetter;

public class UserDaoFactory {

    //private static SessionFactory sesFact;

    public static UserDAO getConnectionDAO() {

        String daoType = PropsGetter.getDaoType("DAO");

        switch (daoType) {

            case "HIBERNATE":
                return new UserHibernateDAO(createSessionFactory(DBHelper.getInstance().getConfiguration()));


            default: throw new IllegalArgumentException("no such DAO type: " + daoType);
        }
    }

//    public static SessionFactory getSessionFactory() {
//        if (sesFact == null) {
//            sesFact = createSessionFactory();
//        }
//        return sesFact;
//    }

    private static SessionFactory createSessionFactory(Configuration cfg) {
        //Configuration configuration = getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return cfg.buildSessionFactory(serviceRegistry);
    }
}
