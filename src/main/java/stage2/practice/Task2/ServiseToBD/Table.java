package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.Main;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table  implements AutoCloseable  {

    static ConnectionCreator conn = new ConnectionCreator();
    static Connection connection;

    static {
        try {
            connection = conn.createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement st;

    static {
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Table() throws SQLException {
    }


    @Override
    public void close() throws IOException {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }
}
