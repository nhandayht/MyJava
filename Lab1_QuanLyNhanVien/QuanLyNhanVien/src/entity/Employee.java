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
public abstract class Employee implements IEmployee {

    protected static int identityCode = 0;
    protected int code;
    protected String name;
    protected Gender gender;
    protected float salary;

    public Employee() {
        code = ++identityCode;
    }

    public Employee(int code, String name, Gender gender, float salary) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input gender: ");
        gender = CheckData.checkGender();
        System.out.print("Input salary: ");
        salary = CheckData.checkSalary();

    }

    @Override
    public void display() {
        System.out.println("-----Information Emloyee-----");
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender.getWord());
        System.out.println("Salary: " + salary);
    }

    @Override
    public abstract float calculateSalary();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
