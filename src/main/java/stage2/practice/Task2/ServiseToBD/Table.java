package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.Main;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table  implements AutoCloseable  {

    ConnectionCreator conn = new ConnectionCreator();
    Connection connection = conn.createConnection();

    public Statement st = connection.createStatement();

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
