package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Service.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CiryOPtoBD extends Table implements Operation{

    public CiryOPtoBD(String str) throws SQLException {
        super(str);
    }


    public void createTable() throws SQLException {
        st.execute("CREATE TABLE IF NOT EXISTS Cityis(" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "type VARCHAR(255) NOT NULL," +
                "area INT NOT NULL," +
                "population DOUBLE NOT NULL,"+
                "dataown VARCHAR(255) NOT NULL)");
    }



    public void Addcell() {
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
            int population  = resultSet.getInt(5);
            long id = resultSet.getLong(6);
            cities.add(new City(name, area,type,dataown,population ,id));
        }
        cities.stream().forEach(x-> System.out.println(x));

    }

    @Override
    public void removecell() {

    }

    @Override
    public void updetecell() {

    }
}
