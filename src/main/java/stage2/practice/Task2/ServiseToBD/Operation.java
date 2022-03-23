package stage2.practice.Task2.ServiseToBD;

import java.sql.SQLException;

public interface Operation {
     void Addcell();
     void printcell() throws SQLException;
     void removecell();
     void updetecell();
}
