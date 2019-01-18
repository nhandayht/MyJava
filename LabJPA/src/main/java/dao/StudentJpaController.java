/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.CreateException;
import exception.DeleteException;
import entity.Student;
import exception.SelectException;
import exception.UpdateException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kynhanht
 */
public class StudentJpaController implements Serializable {

    public StudentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Student create(Student student) throws CreateException {
        EntityManager em = getEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new CreateException();
        } finally {
            em.close();
        }
        return student;

    }

    public Student update(Student student) throws UpdateException {
        EntityManager em = getEntityManager();
        try {

            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new UpdateException();
        } finally {
            em.close();
        }
        return student;
    }

    public Student delete(Student student) throws DeleteException {
        EntityManager em = getEntityManager();
        try {

            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DeleteException();
        } finally {
            em.close();
        }

        return student;
    }

    public List<Student> selectAll() throws SelectException {
        EntityManager em = getEntityManager();
        List<Student> students = null;
        try {
            TypedQuery<Student> creTypedQuery = em.createNamedQuery("Student.findAll", Student.class);
            students = creTypedQuery.getResultList();
        } catch (Exception e) {
            throw new SelectException();
        } finally {
            em.close();
        }

        return students;
    }

    public List<Student> selectAll(int max, int first) throws SelectException {
        EntityManager em = getEntityManager();
        List<Student> students = null;
        try {
            TypedQuery<Student> creTypedQuery = em.createNamedQuery("Student.findAll", Student.class);
            creTypedQuery.setMaxResults(max);
            creTypedQuery.setFirstResult(first);
            students = creTypedQuery.getResultList();
        } catch (Exception e) {
            throw new SelectException();
        } finally {
            em.close();
        }

        return students;
    }

    public List<Student> find(String key, int max, int min) throws SelectException {
        EntityManager em = getEntityManager();
        List<Student> students = null;
        try {
            TypedQuery<Student> creTypedQuery = em.createNamedQuery("Student.finddByNameFullTextSearch", Student.class);
            creTypedQuery.setParameter("key", key);
            creTypedQuery.setMaxResults(max);
            creTypedQuery.setFirstResult(min);
            students = creTypedQuery.getResultList();
        } catch (Exception e) {
            throw new SelectException();
        } finally {
            em.close();
        }
        return students;
    }

}
