/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import dbconnection.exception.DBConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kynhanht
 */
public class DBConnection {

    public static String user = "sa";
    public static String pass = "sa";
    public static String ip = "localhost";
    public static String port = "51091";
    public static String database = "ManageCourse";
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static Connection open() throws DBConnectionException {

        try {
            String url = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + database;
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            throw new DBConnectionException();
        } catch (SQLException ex) {
            throw new DBConnectionException();
        }

    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection cnn) throws DBConnectionException {

        try {
            if (rs != null && !rs.isClosed()) {

                rs.close();
            }
            if (ps != null && !ps.isClosed()) {

                ps.close();
            }
            if (cnn != null && !cnn.isClosed()) {

                cnn.close();
            }
        } catch (SQLException ex) {
            throw new DBConnectionException();
        }
    }
}
