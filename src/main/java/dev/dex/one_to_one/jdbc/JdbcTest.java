package dev.dex.one_to_one.jdbc;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
        String user = "springstudent";
        String pass = "springstudent";

        try {
            System.out.println("Connection to database: " + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println(conn);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
