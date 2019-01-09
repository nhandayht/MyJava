/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ClassRoom;

/**
 *
 * @author kynhanht
 */
public class ClassRoomMapping {
    public static ClassRoomDTO modelToDTO(ClassRoom classRoom){
        if(classRoom!=null){
            ClassRoomDTO classRoomDTO=new ClassRoomDTO(classRoom.getIdClass(), classRoom.getName());
        }
        return null;
    }
    public static ClassRoom dTOToModel(ClassRoomDTO classRoomDTO){
        if(classRoomDTO!=null){
            ClassRoom classRoom=new ClassRoom(classRoomDTO.getIdClass(),classRoomDTO.getName());
        }
        return null;
    }
}
