package stage2.practice.Task2;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.ServiseToBD.CiryOPtoBD;
import stage2.practice.Task2.ServiseToBD.LikeSearch;
import stage2.practice.Task2.ServiseToBD.SreetsTOBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionCreator connection = new ConnectionCreator();
        connection.createConnection();
        String s = "";
        while (!s.equals("-")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    С чем бы вы хотели взаимодействовать ? 
                    1)С городами 
                    2)С улицами 
                    3)Расширенный поиск
                    """);
            String x = sc.nextLine();
            switch (x) {
                case "1" -> {
                    String case1 = "";
                    while (!case1.equals("-")) {
                        CiryOPtoBD citytest = new CiryOPtoBD("");
                        System.out.println("""
                                Чтобы вы хотели сделать?
                                1)Добавить ячейку "город"
                                2)Удалить ячейку "город" 
                                3)Модифициоровать ячейку
                                4)Создать таблицу
                                5)Вывести все ячейки "город"
                                """);
                        String city = sc.nextLine();
                        switch (city) {
                            case "1" -> citytest.Addcell();
                            case "2" -> citytest.removecell();
                            case "3" -> citytest.updetecell();
                            case "4" -> citytest.createTable();
                            case "5" -> citytest.printcell();
                            default -> throw new IllegalStateException("Unexpected value: " + city);
                        }
                        System.out.println("Желаете продолжить работу цикла ?" +
                                "\nЕсли желаете продолжить , то нажмите <+>" +
                                "\nЕсли желаете закончить, то нажмите <->");
                        if (sc.nextLine().equals("-"))
                            case1 = "-";
                    }
                }
                case "2" -> {
                    String case2 = "";
                    while (!case2.equals("-")) {
                        SreetsTOBD streets = new SreetsTOBD();
                        System.out.println("""
                                Чтобы вы хотели сделать?
                                1)Добавить ячейку "улица"
                                2)Удалить ячейку "улица" 
                                3)Модифициоровать ячейку
                                4)Создать таблицу
                                5)Вывести все ячейки "улица"
                                """);
                        String s1 = sc.nextLine();
                        switch (s1) {
                            case "1" -> streets.Addcell();
                            case "2" -> streets.removecell();
                            case "3" -> streets.updetecell();
                            case "4" -> streets.createTable();
                            case "5" -> streets.printcell();
                            default -> throw new IllegalStateException("Unexpected value: " + s1);
                        }
                        System.out.println("Желаете продолжить работу цикла ?" +
                                "\nЕсли желаете продолжить , то нажмите <+>" +
                                "\nЕсли желаете закончить, то нажмите <->");
                        if (sc.nextLine().equals("-"))
                            case2 = "-";
                    }
                }
                case "3" -> {
                    LikeSearch search = new LikeSearch();
                    search.search();
                }
            }
            System.out.println("Желаете продолжить ?" +
                    "\nЕсли желаете продолжить , то нажмите <+>" +
                    "\nЕсли желаете закончить, то нажмите <->");
            if (sc.nextLine().equals("-"))
                s = "-";
        }
    }
}
