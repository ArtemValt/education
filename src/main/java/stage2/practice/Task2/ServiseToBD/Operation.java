package stage2.practice.Task2.ServiseToBD;

import java.sql.SQLException;

public interface Operation {
     void Addcell() throws SQLException;
     void printcell() throws SQLException;
     void removecell() throws SQLException;
     void updetecell() throws SQLException;
}
