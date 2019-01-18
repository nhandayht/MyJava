/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentJpaController;
import exception.CreateException;
import exception.DeleteException;
import exception.SelectException;
import exception.UpdateException;
import dto.StudentDTO;
import entity.Student;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManagerFactory;
import map.StudentMapper;

/**
 *
 * @author kynhanht
 */
public class StudentService implements IService<StudentDTO> {

    StudentJpaController controller = null;
    StudentMapper mapper = null;

    public StudentService() {
        EntityManagerFactory emf = getEntityManagerFactory();
        controller = new StudentJpaController(emf);
        mapper = new StudentMapper();
    }

    @Override
    public Optional<StudentDTO> create(StudentDTO t) throws ParseException, CreateException {
        Student toEntity = mapper.toEntity(t);
        Student student = controller.create(toEntity);
        return Optional.of(mapper.toDTO(student));
    }

    @Override
    public Optional<StudentDTO> delete(StudentDTO t) throws ParseException, DeleteException {
        Student toEntity = mapper.toEntity(t);
        Student student = controller.delete(toEntity);
        return Optional.of(mapper.toDTO(student));
    }

    @Override
    public Optional<StudentDTO> update(StudentDTO t) throws ParseException, UpdateException {
        Student toEntity = mapper.toEntity(t);
        Student student = controller.update(toEntity);
        return Optional.of(mapper.toDTO(student));
    }

    @Override
    public List<StudentDTO> selectAll() throws ParseException, SelectException {
        List<Student> students = controller.selectAll();
        List<StudentDTO> collect = students.stream().map(mapper::toDTO).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentDTO> selectAll(int max, int first) throws ParseException, SelectException {
        List<Student> students = controller.selectAll(max, first);
        List<StudentDTO> collect = students.stream().map(mapper::toDTO).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentDTO> find(String key, int max, int first) throws ParseException, SelectException {
        List<Student> students = controller.find(key, max, max);
        List<StudentDTO> collect = students.stream().map(mapper::toDTO).collect(Collectors.toList());
        return collect;
    }

}
