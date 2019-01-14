/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exception.SelectException;
import dbconnection.exception.DBConnectionException;
import entity.Student;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public interface IStudentDAO extends IDAO<Student, Integer> {
    List<Student> selectByIdCourse(int idCourse) throws DBConnectionException,SelectException;
}
