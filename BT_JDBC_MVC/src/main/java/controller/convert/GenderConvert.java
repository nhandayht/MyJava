/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.convert;

import entity.Gender;

/**
 *
 * @author kynhanht
 */
public class GenderConvert {
    public Gender stringToGender(String sGender){
        Gender gender=(sGender.equals("Male"))?Gender.MALE:Gender.FEMALE;
        return gender;
    }
    public String genderToString(Gender gender){
        String sGender=(gender==Gender.MALE)?"Male":"Female";
        return sGender;
    }
}
