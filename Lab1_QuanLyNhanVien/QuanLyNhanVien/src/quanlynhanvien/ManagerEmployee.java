/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import entity.Employee;
import entity.Manager;
import entity.Officer;
import entity.Worker;
import java.util.List;
import myenum.Gender;

/**
 *
 * @author kynhanht
 */
public class ManagerEmployee {

    public static final int OFFICER = 1;
    public static final int WORKER = 2;
    public static final int MANGER = 3;

    public static void createEmployee(List<Employee> employees, int typeOfEmployee) {
        Employee employee;
        switch (typeOfEmployee) {
            case OFFICER:
                employee = new Officer();
                break;
            case WORKER:
                employee = new Worker();
                break;
            default:
                employee = new Manager();
                break;
        }
        employee.input();
        employees.add(employee);
    }

    public static void displayEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("List of employee is empty!.");
            return;
        }
        for (Employee e : employees) {
            e.display();
        }
    }

    public static void findIncomeForGender(List<Employee> employees, Gender gender) {
        if (employees.isEmpty()) {
            System.out.println("List of employee is empty!.Can't find");
            return;
        }
        float maxIncome = 0;
        for (Employee e : employees) {
            if (e.calculateSalary() > maxIncome && e.getGender() == gender) {
                maxIncome = e.calculateSalary();
            }
        }

        for (Employee e : employees) {
            if (e.calculateSalary() == maxIncome && e.getGender() == gender) {
                e.display();
            }
        }
    }

    public static int getClasses(Employee employee) {
        if (employee instanceof Officer) {
            return OFFICER;
        } else if (employee instanceof Worker) {
            return WORKER;
        } else {
            return MANGER;
        }
    }

    public static void findIncomeForType(List<Employee> employees, int typeOfEmployee) {
        if (employees.isEmpty()) {
            System.out.println("List of employee is empty!.Can't find");
            return;
        }
        float maxIncome = 0;
        for (Employee e : employees) {
            if (e.calculateSalary() > maxIncome && getClasses(e) == typeOfEmployee) {
                maxIncome = e.calculateSalary();
            }
        }

        for (Employee e : employees) {
            if (e.calculateSalary() == maxIncome && getClasses(e) == typeOfEmployee) {
                e.display();
            }
        }
    }

}
