package stage2.practice.Task3.ALG;

import stage2.practice.Task3.Cell;
import stage2.practice.Task3.Location;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static Cell[][] maze;
    private static int rows;
    private static int columns;
    private static Queue<Location> queue;
    private static Location[][] path;
    private static boolean[][] visited;

    public BFS(Cell[][] maze, int rows, int columns) {
        BFS.maze = maze;
        BFS.rows = rows;
        BFS.columns = columns;
        path = new Location[rows][columns];
        visited = new boolean[rows][columns];
        startX = 0;
        startY = 0;
        endX = rows - 1;
        endY = columns - 1;
        queue = new LinkedList<Location>();
        queue.add(new Location(startX, startY));
    }

    public void createRoad(Location[][] path, int x, int y) {
        if (x != startX || y != startY) {
            createRoad(path, path[x][y].getRow(), path[x][y].getColumn());
            maze[x][y] = Cell.PATH;
        }
    }

    public String printlab(Cell[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                sb.append(cell.toString());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int bfs(int curX, int curY) {
        if (curX == endX && curY == endY) {
            createRoad(path, endX, endY);
            maze[endX][endY] = Cell.GOAL;
            System.out.println(printlab(maze));
            return 1;
        }
        queue.poll();
        visited[curX][curY] = true;

        if (curX > 0 && !visited[curX - 1][curY] && maze[curX - 1][curY] != Cell.BLOCKED) {
            path[curX - 1][curY] = new Location(curX, curY);
        }
        if (curY > 0 && !visited[curX][curY - 1] && maze[curX][curY - 1] != Cell.BLOCKED) {
            queue.add(new Location(curX, curY - 1));
            path[curX][curY - 1] = new Location(curX, curY);
        }
        if (curX < rows - 1 && !visited[curX + 1][curY] && maze[curX + 1][curY] != Cell.BLOCKED) {
            queue.add(new Location(curX + 1, curY));
            path[curX + 1][curY] = new Location(curX, curY);
        }
        if (curY < columns - 1 && !visited[curX][curY + 1] && maze[curX][curY + 1] != Cell.BLOCKED) {
            queue.add(new Location(curX, curY + 1));
            path[curX][curY + 1] = new Location(curX, curY);
        }
        Location location = queue.peek();
        if (location == null) {
            return 0;
        } else {
            try {
                return bfs(location.getRow(), location.getColumn());
            } catch (StackOverflowError e) {
                return 0;
            }
        }
    }

}
