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
public class ClassRoomDTO {
    private int idClass;
    private String name;

    public ClassRoomDTO() {
    }

    public ClassRoomDTO(int idClass, String name) {
        this.idClass = idClass;
        this.name = name;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
