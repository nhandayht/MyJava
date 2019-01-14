/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kynhanht
 */
public class DateConvert {
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    public String dateToString(Date date){
        return sdf.format(date);
    }
    public Date stringToDate(String date) throws ParseException{
        return sdf.parse(date);
    }
}
