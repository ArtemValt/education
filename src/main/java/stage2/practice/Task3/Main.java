package stage2.practice.Task3;

import stage2.practice.Task3.ALG.BFS;
import stage2.practice.Task3.ALG.DFS;

import java.sql.SQLException;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Main {

    static int START_X = 0;
    static int START_Y = 0;
    static int row;
    static int columns;
    public static Cell[][] a;


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String s = "";
        System.out.println("""
                \n Ввведите количество рядов и столбцов
                """);
        row = Integer.parseInt(sc.nextLine());
        columns = Integer.parseInt(sc.nextLine());
        GenMaze genMaze = new GenMaze(row, columns);
        Cell[][] a = genMaze.randomlyFill();
        while (!s.equals("-")) {
            System.out.println("Выбрерите что хотите сделать?");
            System.out.println("""
                    \n1)Сгенерировать и вывести  путь от входа до выхода 2 способами 
                    и записать в базу данных 
                    \n2)Очистить базу данных
                     
                    """);
            switch (sc.nextLine()) {
                case "1" -> {

                    System.out.println("НАШ ЛАБИРИНТ");
                    stream(a).forEach(cells -> {
                        stream(cells).forEach(System.out::print);
                        System.out.println();
                    });
                    System.out.println("----------------------------------------------------------");
                    BFS bfs = new BFS(a, row, columns);
                    bfs.createTable();
                    bfs.bfs(START_X, START_Y);
                    DFS dfs = new DFS(a, row, columns);
                    System.out.println("----------------------------------------------------------");
                    dfs.createTable();
                    dfs.solve(new Location(START_X, START_Y));
                    dfs.fillPath();
                }

                case "2" -> {
                    BFS bfs = new BFS(a, row, columns);
                    DFS dfs = new DFS(a, row, columns);
                    bfs.deleteBD();
                    dfs.deleteBD();

                }

                default -> throw new IllegalStateException("Unexpected value: " + sc.nextLine());
            }
            System.out.println("Желаете продолжить?" +
                    "\n Если желаете нажмите <+>" +
                    "\n Если желаете закончить нажмите <->");
            if (sc.nextLine().equals("-"))
                s = "-";
        }

    }
}
