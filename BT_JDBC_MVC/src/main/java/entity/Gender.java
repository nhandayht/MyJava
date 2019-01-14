/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kynhanht
 */
public enum Gender {
    MALE(true,"Male"),FEMALE(false,"Female");
    private boolean codeBoolean;
    private String name;

    private Gender() {
    }

    private Gender(boolean codeBoolean, String name) {
        this.codeBoolean = codeBoolean;
        this.name = name;
    }

    public boolean isCodeBoolean() {
        return codeBoolean;
    }

    public void setCodeBoolean(boolean codeBoolean) {
        this.codeBoolean = codeBoolean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   

    
    
}
