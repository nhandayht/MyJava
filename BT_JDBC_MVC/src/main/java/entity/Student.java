/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author kynhanht
 */
public class Student {
    private int id;
    private Gender gender;
    private String name;
    private Date dob;
    private int idCourse;
    private Course course;

    public Student() {
    }

    public Student(int id, Gender gender, String name, Date dob, int idCourse) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", gender=" + gender + ", name=" + name + ", dob=" + dob + ", idCourse=" + idCourse + '}';
    }
    
    
}
