/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnect.DBConnection;
import entity.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class StudentDAO implements IDAO<Student> {

    public List<Student> selectAll() {
        List<Student> students = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            students = new ArrayList<>();
            String query = "select * from Student";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date d = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                int idClass = rs.getInt("idClass");
                java.util.Date date = new java.util.Date(d.getTime());
                Student student = new Student(id, name, date, gender, idClass);
                students.add(student);

            }
            return students;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;

    }

    @Override
    public Student insert(Student student) {
        if (student != null) {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "insert into Student(name,dob,gender,idClass) values(?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, student.getName());
                ps.setDate(2, new Date(student.getDob().getTime()));
                ps.setBoolean(3, student.isGender());
                ps.setInt(4, student.getIdClass());
                int executeUpdate = ps.executeUpdate();
                if (executeUpdate > 0) {
                    return student;
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                DBConnection.close(rs, ps, connection);
            }
        }
        return null;
    }

    @Override
    public Student updateById(Student student) {
        return null;
    }

    @Override
    public Student deleteById(Student student) {
        if (student != null) {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "delete from Student where id=?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, student.getId());
                ps.executeUpdate();
                int executeUpdate = ps.executeUpdate();
                if (executeUpdate > 0) {
                    return student;
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                DBConnection.close(rs, ps, connection);
            }
        }
        return null;
    }
}
