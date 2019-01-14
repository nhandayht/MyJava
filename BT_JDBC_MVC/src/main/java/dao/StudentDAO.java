/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exception.DeleteException;
import dao.exception.InsertException;
import dao.exception.SelectException;
import dao.exception.UpdateException;
import dbconnection.DBConnection;
import dbconnection.exception.DBConnectionException;
import entity.Course;
import entity.Gender;
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
public class StudentDAO implements IStudentDAO {

    @Override
    public Student insert(Student student) throws DBConnectionException, InsertException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "insert into Student(name,dob,gender,idCourse) values(?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, new Date(student.getDob().getTime()));
            ps.setBoolean(3, student.getGender().isCodeBoolean());
            ps.setInt(4, student.getIdCourse());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return student;
            }

        } catch (SQLException ex) {
            throw new InsertException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public Student updateById(Student student) throws DBConnectionException, UpdateException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "update Student set name=?,dob=?,gender=?,idCourse=? where id=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, new Date(student.getDob().getTime()));
            ps.setBoolean(3, student.getGender().isCodeBoolean());
            ps.setInt(4, student.getIdCourse());
            ps.setInt(5, student.getId());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return student;
            }

        } catch (SQLException ex) {
            throw new UpdateException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public boolean deleteById(Student student) throws DBConnectionException, DeleteException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "delete from Student where id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getId());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            throw new DeleteException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return false;
    }

    @Override
    public List<Student> selectAll() throws DBConnectionException, SelectException {
        List<Student> students = null;
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ICourseDAO idao=new CourseDAO();
        try {
            String query = "select * from Student";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date d = rs.getDate("dob");
                Gender gender = rs.getBoolean("gender") ? Gender.MALE : Gender.FEMALE;
                int idCourse = rs.getInt("idCourse");
                java.util.Date date = new java.util.Date(d.getTime());
                Student student = new Student(id, gender, name, date, idCourse);
                student.setCourse(idao.selectById(idCourse));
                students.add(student);
            }

        } catch (SQLException ex) {
            throw new SelectException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return students;

    }

    @Override
    public Student selectById(Integer id) throws DBConnectionException, SelectException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;
        try {
            String query = "select * from Student where id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Date d = rs.getDate("dob");
                Gender gender = rs.getBoolean("gender") ? Gender.MALE : Gender.FEMALE;
                int idCourse = rs.getInt("idCourse");
                java.util.Date date = new java.util.Date(d.getTime());
                student=new Student(id, gender, name, date, idCourse);
            }

        } catch (SQLException ex) {
            throw new SelectException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return student;
    }

    @Override
    public List<Student> selectByIdCourse(int idCourse) throws DBConnectionException, SelectException {
        List<Student> students = null;
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ICourseDAO idao=new CourseDAO();
        try {
            String query = "select * from Student where idCourse=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1,idCourse);
            rs = ps.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date d = rs.getDate("dob");
                Gender gender = rs.getBoolean("gender") ? Gender.MALE : Gender.FEMALE;
                java.util.Date date = new java.util.Date(d.getTime());
                Student student = new Student(id, gender, name, date, idCourse);
                student.setCourse(idao.selectById(idCourse));
                students.add(student);
            }

        } catch (SQLException ex) {
            throw new SelectException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return students;
    }

}
