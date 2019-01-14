/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dto;

import entity.Course;

/**
 *
 * @author kynhanht
 */
public class StudentDTO {

    private int id;
    private String gender;
    private String name;
    private String dob;
    private int idCourse;
    private CourseDTO courseDTO;

    public StudentDTO() {
    }

    public StudentDTO(int id, String gender, String name, String dob, int idCourse) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.dob = dob;
        this.idCourse = idCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }
    

}
