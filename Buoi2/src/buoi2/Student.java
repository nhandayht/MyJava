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
public class Student {

    public static Student[] students = new Student[5];
    private int id;
    private String name;

    private Student() {
    }
   

    public static Student createStudent() {
        try {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = new Student();
                    return students[i];
                }
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Only create 5 student");
            return null;
        }
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

}
