package stage2.practice.Task2.Connect;
import stage2.practice.Task2.PropertiesUtil;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionCreator {
    private static final String PASSWORD_KEY ="db.password";
    private static final String USERNAME_KEY ="db.username";
    private static final String URL_KEY ="db.url";
    static {
        try {
            String driverName = PropertiesUtil.get("db.driver");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // fatal exception
        }
    }
    public ConnectionCreator() {}
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USERNAME_KEY),PropertiesUtil.get(PASSWORD_KEY));
    }
}