package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;


public class UserDaoFactory {

    public static UserDAO getConnectionDAO() {

        String daoType = DBHelper.getInstance().getDaoType("DAO");

        switch (daoType) {

            case "HIBERNATE":
                return new UserHibernateDAO(createSessionFactory(DBHelper.getInstance().getConfiguration()));


            default: throw new IllegalArgumentException("No such DAO type: " + daoType);
        }
    }

    private static SessionFactory createSessionFactory(Configuration cfg) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return cfg.buildSessionFactory(serviceRegistry);
    }
}
