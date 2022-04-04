package stage2.practice.Task3;

import stage2.practice.Task3.ALG.BFS;
import stage2.practice.Task3.ALG.DFS;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args){
        GenMaze genMaze = new GenMaze(4,4);
        genMaze.randomlyFill();
        Cell[][] a = genMaze.randomlyFill();

        stream(a).forEach(cells -> {
            stream(cells).forEach(System.out::print);
            System.out.println();
        });



        BFS bfs = new BFS(a,4,4);
        System.out.println( bfs.bfs(0,0));

        DFS dfs = new DFS(a, 4, 4);
        dfs.solve(new Location(0, 0));
        dfs.fillPath();    }
}
