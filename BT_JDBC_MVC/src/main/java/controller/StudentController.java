/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.exception.DeleteException;
import dao.exception.InsertException;
import dao.exception.SelectException;
import dao.exception.UpdateException;
import dbconnection.exception.DBConnectionException;
import controller.dto.StudentDTO;
import controller.map.IMapping;
import controller.map.StudentMapping;
import dao.IDAO;
import dao.IStudentDAO;
import dao.StudentDAO;
import entity.Student;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author kynhanht
 */
public class StudentController implements IStudentController {

    IStudentDAO iStudentDAO = new StudentDAO();
    IMapping<Student, StudentDTO> imapping = new StudentMapping();

    @Override
    public List<StudentDTO> selectByIdCourse(int idCourse) throws DBConnectionException, SelectException {
        List<Student> students = iStudentDAO.selectByIdCourse(idCourse);
        List<StudentDTO> collect = students.stream().map((Student t) -> imapping.toDTo(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentDTO insert(StudentDTO t) throws DBConnectionException, InsertException {
        Student student = imapping.toEntity(t);
        return imapping.toDTo(iStudentDAO.insert(student));
    }

    @Override
    public StudentDTO updateById(StudentDTO t) throws DBConnectionException, UpdateException {
        Student student = imapping.toEntity(t);
        return imapping.toDTo(iStudentDAO.updateById(student));
    }

    @Override
    public boolean deleteById(StudentDTO t) throws DBConnectionException, DeleteException {
        Student student = imapping.toEntity(t);
        return iStudentDAO.deleteById(student);
    }

    @Override
    public List<StudentDTO> selectAll() throws DBConnectionException, SelectException {
        List<Student> students = iStudentDAO.selectAll();
        List<StudentDTO> collect = students.stream().map((Student t) -> imapping.toDTo(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentDTO selectById(Integer k) throws DBConnectionException, SelectException {
        return imapping.toDTo(iStudentDAO.selectById(k));
    }

}
