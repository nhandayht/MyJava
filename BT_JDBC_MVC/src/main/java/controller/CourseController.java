/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.exception.DeleteException;
import dao.exception.InsertException;
import dao.exception.SelectException;
import dao.exception.UpdateException;
import dbconnection.exception.DBConnectionException;
import controller.dto.CourseDTO;
import controller.map.CourseMapping;
import controller.map.IMapping;
import dao.CourseDAO;
import dao.ICourseDAO;
import entity.Course;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author kynhanht
 */
public class CourseController implements ICourseController {

    ICourseDAO iCourseDAO = new CourseDAO();
    IMapping<Course, CourseDTO> iMapping = new CourseMapping();

    @Override
    public CourseDTO insert(CourseDTO t) throws DBConnectionException, InsertException {
        Course course = iMapping.toEntity(t);
        return iMapping.toDTo(iCourseDAO.insert(course));
    }

    @Override
    public CourseDTO updateById(CourseDTO t) throws DBConnectionException, UpdateException {
        Course course = iMapping.toEntity(t);
        return iMapping.toDTo(iCourseDAO.updateById(course));
    }

    @Override
    public boolean deleteById(CourseDTO t) throws DBConnectionException, DeleteException {
        Course course = iMapping.toEntity(t);
        return iCourseDAO.deleteById(course);
    }

    @Override
    public List<CourseDTO> selectAll() throws DBConnectionException, SelectException {
        List<Course> courses = iCourseDAO.selectAll();
        List<CourseDTO> collect = courses.stream().map((Course t) -> iMapping.toDTo(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CourseDTO selectById(Integer k) throws DBConnectionException, SelectException {
        return iMapping.toDTo(iCourseDAO.selectById(k));
    }

}
