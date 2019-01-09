/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author kynhanht
 * @param <T>
 */
public interface IController<T> {
    List<T> selectAll();
    T insert(T T); 
    T updateById(T T);
    T deleteById(T T);
}
