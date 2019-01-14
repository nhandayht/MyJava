/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.exception.SelectException;
import dbconnection.exception.DBConnectionException;
import controller.dto.StudentDTO;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public interface IStudentController extends IController<StudentDTO, Integer> {
    List<StudentDTO> selectByIdCourse(int idCourse) throws DBConnectionException,SelectException;
}
