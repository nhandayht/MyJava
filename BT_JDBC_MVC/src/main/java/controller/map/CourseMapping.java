/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.map;

import controller.dto.CourseDTO;
import controller.dto.StudentDTO;
import entity.Course;
import entity.Student;

/**
 *
 * @author kynhanht
 */
public class CourseMapping implements IMapping<Course, CourseDTO>{

    IMapping<Student, StudentDTO> sMapping=new StudentMapping();
    @Override
    public CourseDTO toDTo(Course e) {
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setIdCourse(e.getIdCourse());
        courseDTO.setName(e.getName());
        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO d) {
        Course course=new Course();
        course.setIdCourse(d.getIdCourse());
        course.setName(d.getName());
        return course;
    }


    
}
