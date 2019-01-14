/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.map;

import controller.convert.DateConvert;
import controller.convert.GenderConvert;
import controller.dto.CourseDTO;
import controller.dto.StudentDTO;
import entity.Course;
import entity.Student;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kynhanht
 */
public class StudentMapping implements IMapping<Student, StudentDTO> {

    DateConvert dateConvert = new DateConvert();
    GenderConvert genderConvert = new GenderConvert();
    IMapping<Course, CourseDTO> iMapping = new CourseMapping();

    @Override
    public StudentDTO toDTo(Student e) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(e.getId());
        studentDTO.setGender(genderConvert.genderToString(e.getGender()));
        studentDTO.setName(e.getName());
        studentDTO.setDob(dateConvert.dateToString(e.getDob()));
        studentDTO.setIdCourse(e.getIdCourse());
        studentDTO.setCourseDTO(iMapping.toDTo(e.getCourse()));
        return studentDTO;
    }
    
    @Override
    public Student toEntity(StudentDTO d) {
        Student student = new Student();
        student.setId(d.getId());
        student.setGender(genderConvert.stringToGender(d.getGender()));
        student.setName(d.getName());
        try {
            student.setDob(dateConvert.stringToDate(d.getDob()));
        } catch (ParseException ex) {
            Logger.getLogger(StudentMapping.class.getName()).log(Level.SEVERE, null, ex);
        }
        student.setIdCourse(d.getIdCourse());
        student.setCourse(iMapping.toEntity(d.getCourseDTO()));
        
        return student;
    }
    
}
