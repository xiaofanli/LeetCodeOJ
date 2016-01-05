package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".*/
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        String s = (numerator < 0 ^ denominator < 0) ? "-" : "";
        long numer = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        s += String.valueOf(numer / denom);
        long rmd = numer % denom;
        if(rmd == 0)
            return s;
        s += ".";
        rmd *= 10;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(rmd != 0){
            if(map.containsKey(rmd)){
                StringBuffer sb = new StringBuffer(s);
                sb.insert(map.get(rmd), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(rmd, s.length());
            s += String.valueOf(rmd / denom);
            rmd = (rmd % denom) * 10;
        }
        
        return s;
    }
}
