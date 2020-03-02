package util;

import dao.UserDaoFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropsGetter {

    private static InputStream inputStream;

    private static String connType = "";

    public static String getDaoType(String daoType) {

        try {
            Properties prop = new Properties();
            String propFileName = "dao.properties";

            inputStream = UserDaoFactory.class.getClassLoader().getResourceAsStream(propFileName);

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
