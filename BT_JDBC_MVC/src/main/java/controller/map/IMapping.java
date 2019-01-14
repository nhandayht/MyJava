/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.map;

/**
 *
 * @author kynhanht
 * @param <E>
 * @param <D>
 */
public interface IMapping<E, D> {

    D toDTo(E e);

    E toEntity(D d);

}
