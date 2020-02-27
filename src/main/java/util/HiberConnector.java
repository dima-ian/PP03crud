package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HiberConnector {

    private static SessionFactory sesFact;

    public static SessionFactory getSessionFactory() {
        if (sesFact == null) {
            sesFact = createSessionFactory();
        }
        return sesFact;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getHiberCfg();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration getHiberCfg() {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(User.class);
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/crud_hiber_dm?useUnicode=true&serverTimezone=UTC&useSSL=false");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "q1");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        return cfg;
    }

}
