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
import java.util.List;

/**
 *
 * @author kynhanht
 * @param <T>
 * @param <K>
 */
public interface IController<T,K> {
    T insert(T t) throws DBConnectionException, InsertException;

    T updateById(T t) throws DBConnectionException, UpdateException;

    boolean deleteById(T t) throws DBConnectionException, DeleteException;

    List<T> selectAll() throws DBConnectionException, SelectException;

    T selectById(K k) throws DBConnectionException, SelectException;
}
