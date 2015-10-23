package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.Map;

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null)
            return 0;
        Map<Character, Integer> value = new HashMap<Character, Integer>();
        value.put('I',1);
        value.put('V',5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);
        int ans = 0, prev = 1000;
        for(int i = 0;i < s.length();i++){
            int v = value.get(s.charAt(i));
            ans += v;
            if(prev < v){
                ans -= 2*prev;
                prev = 1000;
            }
            else
                prev = v;
        }
        return ans;
    }
}
