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
    private String name;
    private Date dob;
    private boolean gender;
    private int idClass;

    public Student() {
    }

    public Student(int id, String name, Date birthDay, boolean gender, int idClass) {
        this.id = id;
        this.name = name;
        this.dob = birthDay;
        this.gender = gender;
        this.idClass = idClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    
    
    
}
