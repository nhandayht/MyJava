/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kynhanht
 */
public class StudentMapping {

    public static StudentDTO modelToDTO(Student student) {
        if (student != null) {
            String dob;
            Gender gender;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dob = sdf.format(student.getDob());
            if (student.isGender()) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }

            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), dob, gender, student.getIdClass());
            return studentDTO;
        }
        return null;

    }

    public static Student dTOToModel(StudentDTO studentDTO) {
        if (studentDTO != null) {
            Date dob = null;
            boolean gender;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dob = sdf.parse(studentDTO.getDate());
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            if (studentDTO.getGender() == Gender.MALE) {
                gender = true;
            } else {
                gender = false;
            }
            Student student = new Student(studentDTO.getId(), studentDTO.getName(), dob, gender, studentDTO.getIdClass());
            return student;
        }
        return null;

    }
}
