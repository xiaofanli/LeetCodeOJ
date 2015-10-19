package nju.ics.lixiaofan.algorithm;
/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();
        int i = m.length-1, j = n.length-1;
        char[] ans = i > j ? m : n;
        int idx = Math.max(i, j);
        int x, y, c = 0;
        while(i >= 0 && j >= 0){
        	x = m[i--] - '0';
        	y = n[j--] - '0';
        	ans[idx--] = (char) (x ^ y ^ c + '0');
        	c = x + y + c > 1 ? 1 : 0;
        }
        char tmp = '0'+'1';
        while(c > 0 && idx >= 0){
        	c = ans[idx] -'0';
        	ans[idx] = (char) (tmp - ans[idx]);
        	idx--;
        }
        return c > 0 ? "1"+String.valueOf(ans) : String.valueOf(ans);
    }
}
