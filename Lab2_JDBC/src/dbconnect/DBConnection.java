/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;   
/**
 *
 * @author kynhanht
 */
public class DBConnection {

    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public static Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://localhost:51091;databaseName=ManageClass";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;

    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
