package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelpMethod {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static String formatDate(Date date){
        return dateFormatter.format(date);
    }
    public static Date stringToDate(String dateString) throws ParseException {
        return dateFormatter.parse(dateString);
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // check độ dài của chuỗi nhập vào
    public static boolean checkLength(String str, int length){
        if(str == null) return false;
        return str.trim().length() >= length;
    }

    // check cmt
    public static boolean checkCMT(String str){
        return isNumeric(str) && str.trim().length() == 9;
    }

    // check là số và lớn hơn 0
    public static boolean checkNumber(String str){
        return isNumeric(str) && Double.parseDouble(str)>=0;
    }

    // kiểm tra định dạng ngày nhập
    public static boolean checkDateInput(String str){
        if (str == null) return false;
        try {
            Calendar cal = Calendar.getInstance();
            Date date = dateFormatter.parse(str);
            cal.setTime(date);
            if(cal.get(Calendar.YEAR)<1000) return false;

        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public static boolean checkMonthYearInput(String str){
        Calendar cal = Calendar.getInstance();
        Date dateNow = new Date();
        cal.setTime(dateNow);
        if(str == null) return false;
        if(str.trim().length()==7){
            String [] strList = str.split("/");
            if(strList.length == 2 && strList[0].length()==2 && strList[1].length()==4) {
                try{
                    if(Integer.parseInt(strList[1]) == cal.get(Calendar.YEAR) &&
                            Integer.parseInt(strList[0])<=cal.get(Calendar.MONTH)+1){
                        return true;
                    }else if (Integer.parseInt(strList[1]) < cal.get(Calendar.YEAR)){
                        return 1<= Integer.parseInt(strList[0]) && 12>= Integer.parseInt(strList[0]);
                    }else return false;
                }catch (Exception e) {
                    return false;
                }
            }
            else return false;
        }else return false;
    }
    public static boolean compareMonthYear(Date date, String monthYear){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String [] items = monthYear.split("/");
        if(cal.get(Calendar.YEAR) < Integer.parseInt(items[1])){
            return true;
        }else if((cal.get(Calendar.MONTH) + 1) <= Integer.parseInt(items[0]) && cal.get(Calendar.YEAR)== Integer.parseInt(items[1])){
            return true;
        }
        else return false;
    }
    public static String formatNumber(Double number){
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(number);
    }
}
