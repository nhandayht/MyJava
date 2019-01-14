/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author kynhanht
 */
public class Course {

    private int idCourse;
    private String name;
    private List<Student> student;

    public Course() {
    }

    public Course(int idCourse, String name) {
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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" + "idCourse=" + idCourse + ", name=" + name + ", student=" + student + '}';
    }

}
