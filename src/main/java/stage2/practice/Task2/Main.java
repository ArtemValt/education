package stage2.practice.Task2;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.ServiseToBD.CiryOPtoBD;
import stage2.practice.Task2.ServiseToBD.SreetsTOBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main (String[] args) throws SQLException {
        ConnectionCreator connection = new ConnectionCreator();
        connection.createConnection();
        CiryOPtoBD start = new CiryOPtoBD("Task");
        SreetsTOBD st = new SreetsTOBD();

//        start.createTable();
//        start.Addcell();
//        start.updetecell();
//        start.printcell();
//        start.printcurrentcell();
//        st.createTable();
//        st.Addcell();
//        st.printcell();
//        st.removecell();
//        st.printcell();
        st.printcell();
        st.updetecell();
        st.printcell();

    }

}
