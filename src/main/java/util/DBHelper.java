package util;

import model.User;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

    private static InputStream inputStream;

    private static String connType = "";

    private DBHelper() { }

    private static DBHelper dbHelper;

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("crud_hiber_dm?").          //db name
                    append("user=root&").          //login
                    append("password=q1&").       //password
                    append("serverTimezone=UTC");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public Configuration getConfiguration() {

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

    public String getDaoType(String daoType) {

        try {
            Properties prop = new Properties();
            String propFileName = "dao.properties";

            inputStream = DBHelper.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
                inputStream.close();
            } else {
                inputStream.close();
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            connType = prop.getProperty(daoType);

        } catch (Exception x) {  x.printStackTrace();  }

        return connType;

    }

}
