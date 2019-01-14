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
public class CourseDAO implements ICourseDAO {


    @Override
    public Course insert(Course t) throws DBConnectionException, InsertException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "insert into Course(name) values(?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, t.getName());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return t;
            }

        } catch (SQLException ex) {
            throw new InsertException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public Course updateById(Course t) throws DBConnectionException, UpdateException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "update Course set name=? where idCourse=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, t.getName());
            ps.setInt(2, t.getIdCourse());
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                return t;
            }

        } catch (SQLException ex) {
            throw new UpdateException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public boolean deleteById(Course t) throws DBConnectionException, DeleteException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "delete from Course where idCourse=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, t.getIdCourse());
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
    public List<Course> selectAll() throws DBConnectionException, SelectException {
        List<Course> courses = null;
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        IStudentDAO idao = new StudentDAO();
        try {
            String query = "select * from Course";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            courses = new ArrayList<>();
            while (rs.next()) {
                int idCourse = rs.getInt("idCourse");
                String name = rs.getString("name");
                Course course = new Course(idCourse, name);
                course.setStudent(idao.selectByIdCourse(idCourse));
                courses.add(course);
            }

        } catch (SQLException ex) {
            throw new SelectException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return courses;
    }

    @Override
    public Course selectById(Integer id) throws DBConnectionException, SelectException {
        Connection connection = DBConnection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = null;
        IStudentDAO idao = new StudentDAO();
        try {
            String query = "select * from Course where idCourse=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                course = new Course(id, name);
                course.setStudent(idao.selectByIdCourse(id));
            }

        } catch (SQLException ex) {
            throw new SelectException();
        } finally {
            DBConnection.close(rs, ps, connection);
        }
        return course;
    }

}
