/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author kynhanht
 */
public class StudentDTO {
    private int id;
    private String name;
    private String date;
    private Gender gender;
    private int idClass;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String date, Gender gender, int idClass) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
    
}
