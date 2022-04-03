package stage2.practice.Task3.GenLab;

import stage2.practice.Task2.ServiseToBD.Table;

import java.sql.SQLException;

public class RatMaze extends Table {
    final int N;


    public RatMaze(int n) throws SQLException {
        N = n;
    }


    public void createTable() throws SQLException {
        st.execute("CREATE TABLE IF NOT EXISTS WAY(" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                        "way INTEGER NOT NULL )");
    }
    void printSolution(int[][] sol) throws SQLException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + sol[i][j] + " ");

            }
            System.out.println();
        }
    }
    boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }
    public boolean solveMaze(int[][] maze) throws SQLException {
        int[][] sol = new int[maze.length][maze.length];

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    boolean solveMazeUtil(int[][] maze, int x, int y,
                          int[][] sol) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y) == true) {
            sol[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
}