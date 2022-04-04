package stage2.practice.Task3;

import java.util.Objects;

public  class Location {
    public final int row;
    public final int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}