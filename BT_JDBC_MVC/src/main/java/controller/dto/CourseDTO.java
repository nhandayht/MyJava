/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dto;

import entity.Student;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class CourseDTO {
    private int idCourse;
    private String name;
    private List<StudentDTO> students;

    public CourseDTO() {
    }

    public CourseDTO(int idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
    
    
   
}
