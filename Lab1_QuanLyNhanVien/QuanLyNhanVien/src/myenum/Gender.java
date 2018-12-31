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
    MALE(1, "Male"), FEMALE(2, "Female"), UNKNOWN(-1, "Unknown");
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

    public void setCode(int code) {
        this.code = code;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
