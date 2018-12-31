/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myenum;

/**
 *
 * @author kynhanht
 */
public enum Gender {
       Male(1,"male"),Female(2,"female"),Unknown(-1,"unknown");
       private int code;
       private String word;

    private Gender(int code, String word) {
        this.code = code;
        this.word = word;
    }

    public int getCode() {
        return code;
    }

    public String getWord() {
        return word;
    }
    
       


}
