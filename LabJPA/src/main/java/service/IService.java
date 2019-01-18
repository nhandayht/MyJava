/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import exception.CreateException;
import exception.DeleteException;
import exception.SelectException;
import exception.UpdateException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kynhanht
 */
public interface IService<T> {

    default EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("com.mycompany_LabJPA_jar_1.0-SNAPSHOTPU");
    }

    Optional<T> create(T t) throws ParseException,CreateException;

    Optional<T> delete(T t) throws ParseException,DeleteException;

    Optional<T> update(T t) throws ParseException,UpdateException;

    List<T> selectAll() throws ParseException,SelectException;

    List<T> selectAll(int max, int first) throws ParseException,SelectException;

    List<T> find(String key, int max, int first) throws ParseException,SelectException;

}
