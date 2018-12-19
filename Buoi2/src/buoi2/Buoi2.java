/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi2;

/**
 *
 * @author kynhanht
 */
public class Buoi2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Student student1=Student.createStudent();
            Student student2=Student.createStudent();
            Student student3=Student.createStudent();
            Student student4=Student.createStudent();
            Student student5=Student.createStudent();
            Student student6=Student.createStudent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
