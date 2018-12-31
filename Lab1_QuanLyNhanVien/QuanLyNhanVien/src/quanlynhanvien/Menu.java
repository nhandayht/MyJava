/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import myexception.CheckData;
import entity.Employee;
import java.util.ArrayList;
import java.util.List;
import myenum.Gender;

/**
 *
 * @author kynhanht
 */
public class Menu {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList();//List store all of employees
        int inputOption;// use for option
        int typeOfEmployee;// use to choose type of employee
        int typeOfFinding;// use to find
        Gender gender;
        do {
            //menu
            System.out.println(
                    "1.Input data for employee.\n"
                    + "2.Display all of employees.\n"
                    + "3.Find employee with  highest income.\n"
                    + "4.Exit.\n");
            //input option
            System.out.print("Input option: ");
            inputOption = CheckData.checkInputOption();

            switch (inputOption) {
                //Input data for employee
                case 1:
                    System.out.print("Please input type of employee 1(Officer),2(Worker),3(Manager): ");
                    typeOfEmployee = CheckData.checkTypeOfEmployee();
                    ManagerEmployee.createEmployee(employees, typeOfEmployee);//create employee
                    break;
                //Display all of employee
                case 2:
                    ManagerEmployee.displayEmployee(employees);// display employee
                    break;
                //find employee
                case 3:
                    System.out.print("Please input option for finding employee 1(find with gender),2(find with position): ");
                    typeOfFinding = CheckData.checkTypeOfFinding();
                    //when user choose find by gender
                    if (typeOfFinding == 1) {
                        System.out.print("Please choose gender 0(Male),1(Female),-1(Unknown): ");
                        gender = CheckData.checkGender();
                        ManagerEmployee.findIncomeForGender(employees, gender);//find highest income of employees for gender
                        //when user choose find by type of employee
                    } else {
                        System.out.print("Please choose type of employee 1(Officer),2(Worker),3(Manager): ");
                        typeOfEmployee = CheckData.checkTypeOfEmployee();
                        ManagerEmployee.findIncomeForType(employees, typeOfEmployee);// find highest income of employee for type
                    }
                    break;
                default:
                    break;
            }
        } while (inputOption != 4);

        System.out.println("Exit successfully!");
        System.exit(0);

    }

}
