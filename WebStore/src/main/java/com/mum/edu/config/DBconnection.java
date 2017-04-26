package com.mum.edu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

    private static final String connectionURL = "jdbc:mysql://localhost:80/webstoredb";
    
 // Kết nối vào MySQL.
    public static synchronized Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        return getMySQLConnection(connectionURL, "root", "");
    }
    
    public static synchronized Connection getMySQLConnection(String connectionURL,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

    String retrieveUserFullname(String email) throws ClassNotFoundException {
        String readQuery = "SELECT fullname from users where email = '" + email + "';";
        String fullname = "No information found for the requested user: " + email;

        try (Connection con = DBconnection.getMySQLConnection();
                Statement stmt = con.createStatement();) {
            System.out.println("the query: " + readQuery);
            ResultSet rs = stmt.executeQuery(readQuery);
            while (rs.next()) {
                fullname = rs.getString("fullname");
                System.out.println("User Fullname: " + fullname);
            }
            stmt.close();

        } catch (SQLException s) {
            System.out.println("Exception thrown in retrieveUser ....");
            s.printStackTrace();
        }

        return fullname;

    }

    public String mockRetrieveUserFullname(String email) {
        String fullname = "no definition found";
        switch (email) {
            case "asaad@mum.edu":
                fullname = "Asaad Saad";
                break;
            default: fullname = "CS472 Student";
                break;
        }
        return fullname;
    }

}
