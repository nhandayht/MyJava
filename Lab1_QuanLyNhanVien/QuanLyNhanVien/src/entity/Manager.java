/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import myexception.CheckData;
import myenum.Gender;

/**
 *
 * @author kynhanht
 */
public class Manager extends Employee {

    private int numberOfEmployee;

    public Manager() {
        super();
    }

    public Manager(int numberOfEmployee, int code, String name, Gender gender, float salary) {
        super(code, name, gender, salary);
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Input number of employee: ");
        numberOfEmployee = CheckData.checkNumberOfEmployees();

    }

    @Override
    public void display() {
        super.display();
        System.out.println("Number of Employee: " + numberOfEmployee);

    }

    @Override
    public float calculateSalary() {
        if (numberOfEmployee < 10) {
            return salary + 500;
        } else if (numberOfEmployee >= 10 && numberOfEmployee <= 20) {
            return salary + 1000;
        } else {
            return salary + 2000;
        }
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

}
