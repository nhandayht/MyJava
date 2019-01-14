/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CourseDAO;
import dao.exception.SelectException;
import dbconnection.exception.DBConnectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kynhanht
 */
public class Test {
    public static void main(String[] args) {
        try {
            new CourseDAO().selectAll();
        } catch (DBConnectionException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SelectException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
