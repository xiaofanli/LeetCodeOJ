package nju.ics.lixiaofan.algorithm;
/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/
public class IntegerToRoman {
    public String intToRoman(int num) {
        String res = "";
        while(num >= 1000){
            num -= 1000;
            res += "M";
        }
        if(num >= 900){
            num -= 900;
            res += "CM";
        }
        else if(num >= 500){
            num -= 500;
            res += "D";
        }
        else if(num >= 400){
            num -= 400;
            res += "CD";
        }
        
        while(num >= 100){
            num -= 100;
            res += "C";
        }
        if(num >= 90){
            num -= 90;
            res += "XC";
        }
        else if(num >= 50){
            num -= 50;
            res += "L";
        }
        else if(num >= 40){
            num -= 40;
            res += "XL";
        }
        
        while(num >= 10){
            num -= 10;
            res += "X";
        }
        if(num >= 9){
            num -= 9;
            res += "IX";
        }
        else if(num >= 5){
            num -= 5;
            res += "V";
        }
        else if(num >= 4){
            num -= 4;
            res += "IV";
        }
        
        while(num >= 1){
            num -= 1;
            res += "I";
        }
        
        return res;
    }
}
