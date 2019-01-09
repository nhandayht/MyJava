/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnect.DBConnection;
import entity.ClassRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class ClassRoomDAO implements IDAO<ClassRoom> {

    @Override
    public List<ClassRoom> selectAll() {
        List<ClassRoom> classRooms = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            classRooms = new ArrayList<>();
            String query = "select * from ClassRoom";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idClass = rs.getInt("idClass");
                String name = rs.getString("name");
                ClassRoom c = new ClassRoom(idClass, name);
                classRooms.add(c);

            }
            return classRooms;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public ClassRoom insert(ClassRoom c) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "Insert into ClassRoom(name) values(?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return c;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public ClassRoom updateById(ClassRoom c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassRoom deleteById(ClassRoom c) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "delete from ClassRoom where idClass=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, c.getIdClass());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return c;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

}
