package stage2.practice.Task2;

import stage2.practice.Task2.Connect.ConnectionCreator;
import stage2.practice.Task2.ServiseToBD.CiryOPtoBD;
import stage2.practice.Task2.ServiseToBD.LikeSearch;
import stage2.practice.Task2.ServiseToBD.SreetsTOBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main (String[] args) throws SQLException {
        ConnectionCreator connection = new ConnectionCreator();
        connection.createConnection();
        LikeSearch search = new LikeSearch();
      search.search();



    }

}
