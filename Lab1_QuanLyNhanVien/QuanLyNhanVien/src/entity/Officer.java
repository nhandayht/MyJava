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
public class Officer extends Employee {

    private float factor;

    public Officer() {
        super();
    }

    public Officer(float factor, int code, String name, Gender gender, float salary) {
        super(code, name, gender, salary);
        this.factor = factor;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Input factor: ");
        factor = CheckData.checkFactor();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Factor: " + factor);
    }

    @Override
    public float calculateSalary() {
        return factor * salary;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

}
