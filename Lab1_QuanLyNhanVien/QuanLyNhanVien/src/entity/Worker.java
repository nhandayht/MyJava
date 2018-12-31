/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import myexception.CheckData;
import java.util.Scanner;
import myenum.Gender;

/**
 *
 * @author kynhanht
 */
public class Worker extends Employee {

    private int dayOfWork;

    public Worker() {
        super();
    }

    public Worker(int dayOfWork, int code, String name, Gender gender, float salary) {
        super(code, name, gender, salary);
        this.dayOfWork = dayOfWork;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input day of work: ");
        dayOfWork = CheckData.checkDayOfWork();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Day of work: " + dayOfWork);
    }

    @Override
    public float calculateSalary() {
        return (dayOfWork / 26) * salary;
    }

    public int getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

}
