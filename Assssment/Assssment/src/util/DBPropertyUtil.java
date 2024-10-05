package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String fileName) {
        String connectionString = null;
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream(fileName);
            prop.load(input);
            connectionString = prop.getProperty("db.url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionString;
    }
}
