package stage2.practice.Task3;

import stage2.practice.Task3.GenLab.MazeGen;
import stage2.practice.Task3.GenLab.RatMaze;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько колонн вы бы хотели ввести ");
        int i =sc.nextInt();
        MazeGen mazeGen = new MazeGen(i);
        RatMaze ratMaze = new RatMaze(i);
        int maze[][]=mazeGen.genMaze();
        System.out.println("---------------------------");
      ratMaze.solveMaze(maze);
        ratMaze.createTable();
    }
}
