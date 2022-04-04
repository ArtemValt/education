package stage2.practice.Task3;

public class GenMaze {
    private final int rows, columns;
    private Cell[][] grid;


    public GenMaze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid =new Cell[rows][columns];

    }

    //заполнить лабиринт на 20%
    public Cell[][] randomlyFill() {
        for (int row = 0; row < rows; row++) {

                for (int column = 0; column < columns; column++) {
                if (Math.random() *5 <1) {
                    grid[row][column] = Cell.BLOCKED;
                }
                else
                    grid[row][column] = Cell.EMPTY;
            }
                grid[0][0]=Cell.START;
                grid[columns-1][rows-1]=Cell.GOAL;

        }
        return grid;
    }
    public String toString() {
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
