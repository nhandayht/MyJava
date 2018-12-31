/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexception;

import java.util.Scanner;
import myenum.Gender;

/**
 *
 * @author kynhanht
 */
public class CheckData {

    public static Gender checkGender() {
        Scanner sc = new Scanner(System.in);
        int gender=0;
        while (true) {
            try {
                gender = Integer.parseInt(sc.nextLine().trim());
                if (gender != -1 && gender != 0 && gender != 1) {
                    throw new Exception("Gender must be -1(Unknown) or 0(male) or 1(Female)");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input gender: ");
            }
        }

        switch (gender) {
            case -1:
                return Gender.Unknown;
            case 0:
                return Gender.Male;
            default:
                return Gender.Female;
        }

    }

    public static float checkSalary() {
        Scanner sc = new Scanner(System.in);
        float salary=0;
        while (true) {
            try {
                salary = Float.parseFloat(sc.nextLine().trim());
                if (salary <= 0) {
                    throw new Exception("Salary must >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input salary: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input salary: ");

            }
        }
        return salary;
    }

    public static float checkFactor() {
        Scanner sc = new Scanner(System.in);
        float factor=0;
        while (true) {
            try {
                factor = Float.parseFloat(sc.nextLine().trim());
                if (factor <= 0) {
                    throw new Exception("Salary must >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input factor: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input factor: ");

            }
        }
        return factor;
    }

    public static int checkDayOfWork() {
        Scanner sc = new Scanner(System.in);
        int dayOfWork=0;
        while (true) {
            try {
                dayOfWork = Integer.parseInt(sc.nextLine().trim());
                if (dayOfWork <= 0) {
                    throw new Exception("Day of work must >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input day of work: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input day of work: ");

            }
        }
        return dayOfWork;
    }

    public static int checkNumberOfEmployees() {
        Scanner sc = new Scanner(System.in);
        int numberOfEmployee=0;
        while (true) {
            try {
                numberOfEmployee = Integer.parseInt(sc.nextLine().trim());
                if (numberOfEmployee < 0) {
                    throw new Exception("Number of employee must >=0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input number of employee: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input number of employee: ");

            }
        }
        return numberOfEmployee;
    }
    public static int checkInputOption() {
        Scanner sc = new Scanner(System.in);
        int inputOption=0;
        while (true) {
            try {
                inputOption = Integer.parseInt(sc.nextLine().trim());
                if (inputOption<1 || inputOption>4) {
                    throw new Exception("Error!You must choose option 1 from 4");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input option: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input option: ");

            }
        }
        return inputOption;
    }
    public static int checkTypeOfEmployee() {
        Scanner sc = new Scanner(System.in);
        int typeOfEmployee=0;
        while (true) {
            try {
                typeOfEmployee = Integer.parseInt(sc.nextLine().trim());
                if (typeOfEmployee>3 || typeOfEmployee<1) {
                    throw new Exception("Error!You must choose type 1 from 3");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input type of employee: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input type of employee: ");

            }
        }
        return typeOfEmployee;
    }
    public static int checkTypeOfFinding() {
        Scanner sc = new Scanner(System.in);
        int typeOfFinding=0;
        while (true) {
            try {
                typeOfFinding = Integer.parseInt(sc.nextLine().trim());
                if (typeOfFinding>2 || typeOfFinding<1) {
                    throw new Exception("Error!You must choose type 1 from 2");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.out.print("Input type of finding: ");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Input type of finding: ");

            }
        }
        return typeOfFinding;
    }
}
