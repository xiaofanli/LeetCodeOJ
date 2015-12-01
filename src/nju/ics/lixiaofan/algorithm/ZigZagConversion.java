package nju.ics.lixiaofan.algorithm;
/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows)
            return s;
        String res = "";
        for(int i = 0;i < numRows;i++){
            boolean flip = true;
            for(int j = 0;j < s.length();j += numRows-1){
                flip = !flip;
                if(flip && i == 0 || !flip && i == numRows-1)
                    continue;
                int idx = flip ? j + numRows-1 - i : j + i;
                if(idx < s.length())
                    res += String.valueOf(s.charAt(idx));
            }
        }
        return res;
    }
}
