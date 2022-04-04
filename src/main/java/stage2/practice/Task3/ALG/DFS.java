package stage2.practice.Task3.ALG;

import stage2.practice.Task3.Cell;
import stage2.practice.Task3.Location;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {
    private Cell[][] maze;
    private Location[][] prev;

    private int width;
    private int length;

    private Location lastNode;

    public DFS(Cell[][] maze, int length, int width)   {

        this.maze = maze;
        this.length = length;
        this.width = width;

        prev = new Location[length][width];
    }  private boolean inBoundsX(int number){
    return number >= 0 && number < width;
}

    private boolean inBoundsY(int number){
        return number >= 0 && number < length;
    }

    public void solve(Location start){

        Stack<Location> stack = new Stack<>();
        HashSet<Location> visited = new HashSet<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Location tmp = stack.pop();
            visited.add(tmp);

            if (maze[tmp.getRow()][tmp.getColumn()]==Cell.GOAL) {
                lastNode = tmp;
                break;
            }

            for(Location point : this.getAdjacentEdges(tmp)) {
                if (!visited.contains(point)) {
                    stack.push(point);
                    prev[point.getColumn()][point.getRow()] = tmp;
                }
            }
        }
    }

    public void fillPath()  {
        if (lastNode == null) {
            System.out.println("No path in maze");
        } else {
            // assume, that start point and end point are different
            for (;;) {
                lastNode = prev[lastNode.getColumn()][lastNode.getRow()];

                // There's no previous node for start point, so we can break
                if (lastNode == null) {
                    break;
                }

                if (maze[lastNode.getColumn()][lastNode.getRow()] != Cell.START) {
                    maze[lastNode.getColumn()][lastNode.getRow()] = Cell.PATH;

                }
            }
            System.out.println(printlab(maze));
        }
    }

    private List<Location> getAdjacentEdges(Location tmp) {
        List<Location> neighbours = new ArrayList<>();
        if(this.inBoundsX(tmp.getRow()+1)){
            if(this.maze[tmp.getColumn()][tmp.getRow()+1] != Cell.BLOCKED){
                neighbours.add(new Location(tmp.getRow()+1, tmp.getColumn()));
            }
        }
        if(this.inBoundsX(tmp.getRow()-1)){
            if(this.maze[tmp.getColumn()][tmp.getRow()-1] != Cell.BLOCKED){
                neighbours.add(new Location(tmp.getRow()-1, tmp.getColumn()));
            }
        }
        if(this.inBoundsY(tmp.getColumn()+1)){
            if(this.maze[tmp.getColumn()+1][tmp.getRow()] != Cell.BLOCKED){
                neighbours.add(new Location(tmp.getRow(), tmp.getColumn()+1));
            }
        }
        if(this.inBoundsY(tmp.getColumn()-1)){
            if(this.maze[tmp.getColumn()-1][tmp.getRow()] != Cell.BLOCKED){
                neighbours.add(new Location(tmp.getRow(), tmp.getColumn()-1));
            }
        }
        return neighbours;
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
}
