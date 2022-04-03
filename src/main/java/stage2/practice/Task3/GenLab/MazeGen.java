package stage2.practice.Task3.GenLab;

public class MazeGen {
    private int[][] maze;
    private int sizegen;

    public MazeGen(int sizegen) {
        this.sizegen = sizegen;
        maze = new int[sizegen][sizegen];
    }

    public int[][] genMaze() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = getR();
            for (int j = 0; j < maze.length; j++) {
                maze[i][j] = getR();
            }
        }
        for (int i = 0; i < maze.length; i++) {
            if (i == 1)
                sb.replace(1, 2, "1");
            for (int j = 0; j < maze.length; j++) {
                sb.append(maze[i][j] != 0 ? " 1 " : " 0 ");
            }
            sb.append("\n");
            if (i == sizegen - 1)
                sb.replace(sb.lastIndexOf("0"), sb.lastIndexOf("0") + 1, "1");
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {

                if(maze[i][j]!=0)
                    maze[i][j] = 1;
            }
            if (i == 0) {
                maze[i][2] = 1;
            }

            if (i == sizegen - 1) {
                maze[i][i] = 1;
            }
        }
       System.out.print(sb);
        return maze;
    }

    public int getR() {
        return (int) (Math.random() * 4);
    }


}












