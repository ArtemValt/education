package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Service.City;
import stage2.practice.Task2.Service.Streets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SreetsTOBD extends Table implements Operation {
    public SreetsTOBD() throws SQLException {
    }

    public void createTable() throws SQLException {
        st.execute("CREATE TABLE IF NOT EXISTS streets(" +
                "ID BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "NAME VARCHAR(255) NOT NULL," +
                "TYPE VARCHAR(255) NOT NULL," +
                "city_id INTEGER NOT NULL, " +
                "FOREIGN KEY (city_id) REFERENCES Cityis(id))");
    }

    @Override
    public void Addcell() {
        Scanner sc = new Scanner(System.in);
        String name, type;
        System.out.println("Введите id города,которому принаджелит данная улица");
        String id = sc.nextLine();
        System.out.println("Введите название улицы: ");
        name = sc.nextLine();
        System.out.println("Введите тип улицы: ");
        type = sc.nextLine();
        try {
            st.execute("INSERT INTO streets (NAME,TYPE,city_id)  " +
                    "values('" + name + "', '" + type + "', '" + id + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printcell() throws SQLException {
        List<Streets> streets = new ArrayList<>();
        String sql = "SELECT  id ,name, type , city_id FROM streets";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String type = resultSet.getString(3);
            int city_id = resultSet.getInt(4);
            streets.add(new Streets(id, name, type, city_id));
        }
        streets.stream().forEach(x -> System.out.println(x));

    }

    @Override
    public void removecell() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите id ячейки что хотите удалить");
        int x = sc.nextInt();
        st.executeUpdate("DELETE FROM streets WHERE id = " + x);
    }

    @Override
    public void updetecell() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (!str.equals("-")) {
            System.out.println("Введите id ячейки,название которой хотите поменять");
            String cell = sc.nextLine();
            System.out.println("""
                    "Выберите действие ,которое хотите сделеать"
                    1)Сменить название улицы
                    2)Сменить тип
                    3)Сменить ранее назначенный город  
                    """);
            String answer = sc.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Введите новое название улицы ");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE streets " +
                            "SET NAME = '" + answer + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "2":
                    System.out.println("Введите новый тип улицы");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE streets " +
                            "SET type = '" + answer + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "3":
                    System.out.println("Введите новый город назначения");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE streets " +
                            "SET city_id = '" + Integer.parseInt(answer) + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
            System.out.println("Желаете продолжить нажмите <+>" +
                    "\nЕсли хотите закончить нажмите <->");
            if (sc.nextLine().equals("-"))
                str = "-";
        }


    }
}
