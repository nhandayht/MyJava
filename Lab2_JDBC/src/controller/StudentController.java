/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IDAO;
import dao.StudentDAO;
import entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class StudentController implements IController<StudentDTO> {

    IDAO<Student> dao;

    @Override
    public List<StudentDTO> selectAll() {
        dao = new StudentDAO();
        List<Student> students = dao.selectAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        students.stream().map((s) -> StudentMapping.modelToDTO(s)).forEachOrdered((studentDTO) -> {
            studentDTOs.add(studentDTO);
        });
        return studentDTOs;

    }

    @Override
    public StudentDTO insert(StudentDTO T) {
        Student student=StudentMapping.dTOToModel(T);
        dao = new StudentDAO();
        dao.insert(student);
        return T;
    }

    @Override
    public StudentDTO updateById(StudentDTO T) {
        return null;
    }

    @Override
    public StudentDTO deleteById(StudentDTO T) {
        Student student=StudentMapping.dTOToModel(T);
        dao = new StudentDAO();
        dao.deleteById(student);
        return T;
        
    }

}
