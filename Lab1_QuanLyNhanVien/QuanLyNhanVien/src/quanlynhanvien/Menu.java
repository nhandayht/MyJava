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
        List<Employee> employees = new ArrayList();
        int inputOption;
        int typeOfEmployee;
        int typeOfFinding;
        Gender gender;
        do {
            System.out.println(
                    "1.Input data for employee.\n"
                    + "2.Display all of employees.\n"
                    + "3.Find employee with  highest income.\n"
                    + "4.Exit.\n");
            System.out.print("Input option: ");
            inputOption = CheckData.checkInputOption();
            switch (inputOption) {
                case 1:
                    System.out.print("Please input type of employee 1(Officer),2(Worker),3(Manager): ");
                    typeOfEmployee = CheckData.checkTypeOfEmployee();
                    ManagerEmployee.createEmployee(employees, typeOfEmployee);
                    break;
                case 2:
                    ManagerEmployee.displayEmployee(employees);
                    break;
                case 3:
                    System.out.print("Please input option for finding employee 1(find with gender),2(find with position): ");
                    typeOfFinding = CheckData.checkTypeOfFinding();
                    if (typeOfFinding == 1) {
                        System.out.print("Please choose gender 0(Male),1(Female),-1(Unknown): ");
                        gender = CheckData.checkGender();
                        ManagerEmployee.findIncomeForGender(employees, gender);
                    } else {
                        System.out.print("Please choose type of employee 1(Officer),2(Worker),3(Manager): ");
                        typeOfEmployee = CheckData.checkTypeOfEmployee();
                        ManagerEmployee.findIncomeForType(employees, typeOfEmployee);
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
