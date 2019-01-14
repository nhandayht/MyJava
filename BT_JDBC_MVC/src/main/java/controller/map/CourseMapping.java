/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.map;

import controller.StudentController;
import controller.dto.CourseDTO;
import controller.dto.StudentDTO;
import entity.Course;
import entity.Student;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author kynhanht
 */
public class CourseMapping implements IMapping<Course, CourseDTO> {

    IMapping<Student, StudentDTO> sMapping;

    @Override
    public CourseDTO toDTo(Course e) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setIdCourse(e.getIdCourse());
        courseDTO.setName(e.getName());
        if (e.getStudent() != null) {
            sMapping = new StudentMapping();
            List<StudentDTO> collect = e.getStudent().stream().map((Student t) -> sMapping.toDTo(t)).collect(Collectors.toList());
            courseDTO.setStudents(collect);
        }
        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO d) {
        Course course = new Course();
        course.setIdCourse(d.getIdCourse());
        course.setName(d.getName());
        return course;
    }

}
