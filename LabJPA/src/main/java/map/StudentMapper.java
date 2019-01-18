/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import entity.Student;
import dto.StudentDTO;
import java.text.ParseException;
import map.ulti.DateTimeConverter;

/**
 *
 * @author kynhanht
 */
public class StudentMapper implements IMapping<Student, StudentDTO> {

    @Override
    public StudentDTO toDTO(Student t) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(t.getId());
        studentDTO.setName(t.getName());
        DateTimeConverter dtc = new DateTimeConverter();
        studentDTO.setDob(dtc.dateToString(t.getDob()));
        return studentDTO;
    }

    @Override
    public Student toEntity(StudentDTO t) throws ParseException {
        Student student = new Student();
        student.setId(t.getId());
        student.setName(t.getName());
        DateTimeConverter dtc = new DateTimeConverter();
        student.setDob(dtc.stringToDate(t.getDob()));
        return student;
    }

}
