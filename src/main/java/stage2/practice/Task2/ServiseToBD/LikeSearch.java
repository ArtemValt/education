package stage2.practice.Task2.ServiseToBD;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LikeSearch extends Table {
    List<String> task = new ArrayList<>();

    public LikeSearch() throws SQLException {

    }

    public void searchByname() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя города которого хотите найти ");
        String answ = sc.nextLine();
        ResultSet rs = st.executeQuery("SELECT * FROM Cityis WHERE LOWER(NAME) " +
                "LIKE LOWER('%" + answ + "%');");
        task.add("\nПоиск города по имени " + answ);
        while (rs.next()) {
            System.out.println("\t- " + rs.getString("TYPE") +
                    "  " + rs.getString("NAME") + " с площадью " + rs.getString("area") + " тысячи (км) с населенеием "
                    + rs.getString("population") + " тыс. человек ");

            task.add("\t- " + rs.getString("TYPE") +
                    "  " + rs.getString("NAME") + " с площадью " + rs.getString("area") + " тысячи (км) с населенеием "
                    + rs.getString("population") + " тыс. человек ");
        }
    }

    public void searchByArea() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую бы вы операцию хотели совершить ");
        String op = sc.nextLine();
        System.out.println("По какому значению будет произведен фильтр");
        String filt = sc.nextLine();
        ResultSet rs = st.executeQuery("SELECT * FROM Cityis WHERE area " + op + " " +
                filt + ";");
        task.add("\nПоиск по по плозади равной " + filt + " с фильтром " + op);
        while (rs.next()) {
            System.out.println("\t- " + rs.getString("TYPE") +
                    "  " + rs.getString("NAME") + " с площадью " + rs.getString("area"));
            task.add(rs.getString("TYPE")
                    + " " + rs.getString("NAME")
                    + " с площадью " + rs.getString("area") + "\n");
        }
    }

    public void searchbyPopul() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую бы вы операцию хотели совершить ");
        String op = sc.nextLine();
        System.out.println("По какому значению будет произведен фильтр");
        String filt = sc.nextLine();
        ResultSet rs = st.executeQuery("SELECT * FROM Cityis WHERE POPULATION " + op + " " +
                filt + ";");
        task.add("\nПоиск по по количеству населения " + filt + " с фильтром " + op);
        while (rs.next()) {
            System.out.println("\t- " + rs.getString("TYPE") +
                    "  " + rs.getString("NAME") + " с площадью " + rs.getString("area"));
            task.add(rs.getString("TYPE")
                    + " " + rs.getString("NAME")
                    + " с населенеием " + rs.getString("POPULATION") + " тыс. человек\n");
        }
    }

    public void searchBynameStrets() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Выбрано: По названию улицы (like запрос)\nВведите название улицы (like запрос): ");
        String answer = sc.nextLine();
        String id = "";
        int count = 0;

        ResultSet rs = st.executeQuery("SELECT Cityis.ID, Cityis.TYPE, Cityis.NAME," +
                " STREETS.TYPE, STREETS.NAME" +
                " FROM Cityis, STREETS WHERE (LOWER(STREETS.NAME) " +
                "LIKE LOWER('%" + answer + "%'))" +
                "AND (Cityis.ID = STREETS.cityID);");

        while (rs.next()) {
            if (!id.equals(rs.getString("Cityis.ID"))) {
                System.out.println(rs.getString("Cityis.TYPE") + " \"" + rs.getString("Cityis.NAME") + "\"");
                task.add("\nВ " + rs.getString("Cityis.TYPE") + " \"" + rs.getString("Cityis.NAME") +
                        "\"\nНашлись такие улицы: ");
                id = rs.getString("Cityis.ID");
            }
            count++;
            System.out.println("\t- " + rs.getString("STREETS.TYPE") +
                    "\" " + rs.getString("STREETS.NAME") + "\"");
            task.add("\t- " + rs.getString("STREETS.TYPE") +
                    " \"" + rs.getString("STREETS.NAME") + "\"");
        }
        if (count == 0) {
            System.out.println("Городов с такими именами улиц нет :(");
            task.add("Городов с такими именами улиц нет :(");
        }
    }

    public void searchByAge() throws SQLException {
        System.out.println("Какую операцию вы бы хотели выбрать " +
                "\n 1) Строгое соответсвие" +
                "\n 2) В диапазоне");
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        switch (x) {
            case "1" -> {
                System.out.println("Введите дату");
                String date = sc.nextLine();
                task.add("\nУлицы с датой основания " + date + "\n");
                ResultSet rs = st.executeQuery("SELECT * FROM Cityis WHERE dataown = '" + date + "';");
                while (rs.next()) {
                    System.out.println("\t- " + rs.getString("TYPE") +
                            "  " + rs.getString("NAME") + " c датой основания "
                            + rs.getString("dataown"));
                    task.add(rs.getString("TYPE")
                            + " " + rs.getString("NAME")
                            + " c датой основания " + rs.getString("dataown") + "\n");
                }
            }
            case "2" -> {
                System.out.println("Введите 1 дату диапазона ");
                String date1 = sc.nextLine();
                System.out.println("Введите 2 дату диапазона ");
                String date2 = sc.nextLine();
                task.add("\nУлицы с датой основания в диапазоне от " + date1 + " до " + date2 + "\n");

                ResultSet rs = st.executeQuery("SELECT * FROM Cityis WHERE dataown BETWEEN '" + date1 + "' AND '" + date2 + "';");
                while (rs.next()) {
                    System.out.println("\t- " + rs.getString("TYPE") +
                            "  " + rs.getString("NAME") + " c датой основания "
                            + rs.getString("dataown"));
                    task.add(rs.getString("TYPE")
                            + " " + rs.getString("NAME")
                            + " c датой основания " + rs.getString("dataown") + "\n");
                }
            }
            default -> System.out.println("Такого выбора нет");
        }
    }

    public void searchByType() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип улицы которого хотите найти ");
        String answ = sc.nextLine();
        ResultSet rs = st.executeQuery("SELECT * FROM streets WHERE type  " +
                "LIKE ('%" + answ + "%');");
        task.add("\nУлицы по типу " + answ + "\n");
        while (rs.next()) {
            System.out.println("Name = " + rs.getString(2) + " Type = " +
                    rs.getString(3) + " City_id = " + rs.getString(4));
            task.add(
                    "Name = " + rs.getString(2) + " Type = " +
                            rs.getString(3) + " City_id = " + rs.getString(4));
        }

    }

    public void search() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (!str.equals("-")) {
            System.out.println("""
                    Какую операцию бы вы хотели выполнить ?
                    Получать справочную информацию о наличии населенных пунктов,
                    1 по названию населенного пункта (like запрос)
                    2 по количеству жителей (>,<,=,!=,<=,>=)
                    3 по площади (>,<,=,!=,<=,>=)
                    4 дате основания (строгое соответствие и в диапазоне)
                    5 по названию улицы (like запрос)
                    6 по типу улицы (строгое соответствие)
                    7 показать файл запросов
                    8 Записать историю запросов в файл (ТХТ)
                    """);
            String answ = sc.nextLine();
            switch (answ) {
                case "1" -> searchByname();
                case "2" -> searchbyPopul();
                case "3" -> searchByArea();
                case "4" -> searchByAge();
                case "5" -> searchBynameStrets();
                case "6" -> searchByType();
                case "7" -> task.stream().forEach(x -> System.out.println(x));
                case "8" -> tofile();
                default -> System.out.println("Такого выбора нет");
            }
            System.out.println("Желаете продолжить ? " +
                    "\n Если да , то нажмите <+>" +
                    "\n Если нет , то нажмите <->");
            if (sc.nextLine().equals("-"))
                str = "-";
        }
    }

    public void tofile() {
        try {
            FileWriter nFile = new FileWriter("search.txt");
            for (String a : task)
                nFile.write(a);
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
