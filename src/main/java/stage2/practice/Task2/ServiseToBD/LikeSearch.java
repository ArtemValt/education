package stage2.practice.Task2.ServiseToBD;

import stage2.practice.Task2.Service.City;
import stage2.practice.Task2.Service.Streets;

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
    List<City> cityes = new ArrayList<>();
    List<Streets> streets = new ArrayList<>();

    public void upcoCityslection () throws SQLException {
        String sql = "SELECT name, area, type , dataown , population , id FROM Cityis";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int area = resultSet.getInt(2);
            String type = resultSet.getString(3);
            int dataown = resultSet.getInt(4);
            int population = resultSet.getInt(5);
            long id = resultSet.getLong(6);
            cityes.add(new City(name, area, type, dataown, population, id));
        }
    }
    public void upcollstreats() throws SQLException {
        String sql = "SELECT id,name, type,cityID  FROM streets";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()) {
            int i = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String type = resultSet.getString(3);
            int cityid = resultSet.getInt(4);
            streets.add(new Streets(i,name,type,cityid))     ;
        }

    }
    public void searchByname() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя города которого хотите найти ");
        String answ = sc.nextLine();
        task.add("\nПоиск города по имени " + answ);
        cityes.stream().filter(x->x.getName().equals(answ)).forEach(x-> System.out.println(x));

        }

    public void searchByArea() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую бы вы операцию хотели совершить ");
        String op = sc.nextLine();
        System.out.println("По какому значению будет произведен фильтр");
        String filt = sc.nextLine();
        switch (op) {
            case ">" -> cityes.stream().filter(x -> x.getArea() > Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "=" -> cityes.stream().filter(x -> x.getArea() == Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "<" -> cityes.stream().filter(x -> x.getArea() < Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "<=" -> cityes.stream().filter(x -> x.getArea() <= Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case ">=" -> cityes.stream().filter(x -> x.getArea() >= Integer.parseInt(filt)).forEach(x -> System.out.println(x));
        }


    }


    public void searchbyPopul() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую бы вы операцию хотели совершить ");
        String op = sc.nextLine();
        System.out.println("По какому значению будет произведен фильтр");
        String filt = sc.nextLine();
        switch (op) {
            case ">" -> cityes.stream().filter(x -> x.getAreaNumber() > Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "=" -> cityes.stream().filter(x -> x.getAreaNumber() == Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "<" -> cityes.stream().filter(x -> x.getAreaNumber() < Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case "<=" -> cityes.stream().filter(x -> x.getAreaNumber() <= Integer.parseInt(filt)).forEach(x -> System.out.println(x));
            case ">=" -> cityes.stream().filter(x -> x.getAreaNumber() >= Integer.parseInt(filt)).forEach(x -> System.out.println(x));
        }

    }

    public void searchBynameStrets() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Выбрано: По названию улицы (like запрос)\nВведите название улицы (like запрос): ");
        String answer = sc.nextLine();
        streets.stream().filter(x->x.getName().contains(answer)).forEach(x-> System.out.println(x));


        }



    public void searchByAge() throws SQLException {
        System.out.println("Какую операцию вы бы хотели выбрать " +
                "\n 1) Строгое соответсвие" +
                "\n 2) В диапазоне");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        switch (a) {
            case "1" -> {
                System.out.println("Введите дату");
                String date = sc.nextLine();
                task.add("\nУлицы с датой основания " + date + "\n");
                cityes.stream().filter(x -> x.getDataown() == Integer.parseInt(date))
                        .forEach(x -> System.out.println(x));
            }
            case "2" -> {
                System.out.println("Введите 1 дату диапазона ");
                String date1 = sc.nextLine();
                System.out.println("Введите 2 дату диапазона ");
                String date2 = sc.nextLine();
                task.add("\nУлицы с датой основания в диапазоне от " + date1 + " до " + date2 + "\n");
                cityes.stream().filter(x -> x.getDataown() > Integer.parseInt(date1) && x.getDataown() < Integer.parseInt(date2))
                        .forEach(x -> System.out.println(x));
            }
            default -> System.out.println("Такого выбора нет");
        }
    }

    public void searchByType() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип улицы которого хотите найти ");
        String answ = sc.nextLine();
        streets.stream().filter(x->x.getType().equals(answ)).forEach(x-> System.out.println(x));
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
                    9 показать все города
                    
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
                case "9" -> printcitys();
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

        public void printcitys() throws SQLException {
        CiryOPtoBD ciryOPtoBD = new CiryOPtoBD();
        ciryOPtoBD.printcell();
        }
}
