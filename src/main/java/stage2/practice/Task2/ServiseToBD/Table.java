package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.Main;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table  implements AutoCloseable  {
    String tableName;
    ConnectionCreator conn = new ConnectionCreator();
    Connection connection = conn.createConnection();

    Statement st = connection.createStatement();

    public Table(String str) throws SQLException {
        this.tableName=str;
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
