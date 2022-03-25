package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Service.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CiryOPtoBD extends Table implements Operation {

    public CiryOPtoBD(String str) throws SQLException {
        super(str);
    }


    public void createTable() throws SQLException {
        st.execute("CREATE TABLE IF NOT EXISTS Cityis(" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL ," +
                "type VARCHAR(255) NOT NULL," +
                "area INT NOT NULL," +
                "population DOUBLE NOT NULL," +
                "dataown VARCHAR(255) NOT NULL)");
    }


    @Override
    public void Addcell() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String name, type, dataown;
        int area;
        double population;
        System.out.println("Введите название населенного пункта: ");
        name = sc.nextLine();

        System.out.println("Введите тип населенного пункта: ");
        type = sc.nextLine();

        System.out.println("Введите площадь населенного пункта в киллометрах: ");
        area = Integer.parseInt(sc.nextLine());

        System.out.println("Введите количество жителей в тысячах: ");
        population = Double.parseDouble(sc.nextLine());

        System.out.println("Введите дату основания: ");
        dataown = sc.nextLine();

        try {
            st.execute("INSERT INTO Cityis (NAME, TYPE, area, POPULATION, dataown)  " +
                    "values('" + name + "', '" + type + "', " + area + ", " + population + ", '" + dataown + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void printcell() throws SQLException {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT name, area, type , dataown , population , id FROM Cityis";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int area = resultSet.getInt(2);
            String type = resultSet.getString(3);
            int dataown = resultSet.getInt(4);
            int population = resultSet.getInt(5);
            long id = resultSet.getLong(6);
            cities.add(new City(name, area, type, dataown, population, id));
        }
        cities.stream().forEach(x -> System.out.println(x));
    }

    @Override
    public void removecell() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите id ячейки что хотите удалить");
        int x = sc.nextInt();
        st.executeUpdate("DELETE FROM Cityis WHERE id = " + x);

    }

    @Override
    public void updetecell() throws SQLException {
        printcell();
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (!str.equals("-")) {
            System.out.println("Введите id ячейки,название которой хотите поменять");
            String cell = sc.nextLine();
            System.out.println("""
                    "Выберите действие ,которое хотите сделеать"
                    1)Сменить название города
                    2)Сменить площадь
                    3)Сменить тип
                    4)Сменить дату основания
                    5)Сменить количество жителей в городе
                    """);
            String answer = sc.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Введите новое название города");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE Cityis " +
                            "SET NAME = '" + answer + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "2":
                    System.out.println("Введите новоую площадь города");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE Cityis " +
                            "SET area = '" + Integer.parseInt(answer) + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "3":
                    System.out.println("Введите новый тип города");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE Cityis " +
                            "SET type = '" + answer + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "4":
                    System.out.println("Введите новую  дату основания");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE Cityis " +
                            "SET dataown = '" + answer + "' WHERE ID = " + Integer.parseInt(cell));
                    break;
                case "5":
                    System.out.println("Введите новое количество жителей в городе");
                    answer = sc.nextLine();
                    st.executeUpdate("UPDATE Cityis " +
                            "SET population = '" + Double.parseDouble(answer) + "' WHERE ID = " + Integer.parseInt(cell));
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
