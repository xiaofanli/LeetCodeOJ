package nju.ics.lixiaofan.algorithm;
/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	public static void main(String[] args) {
		String n1 = "99", n2 = "9999";
		MultiplyStrings a = new MultiplyStrings();
		System.out.println(a.multiply(n1, n2));
	}
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        int[] ans = new int[num1.length()+num2.length()];//LSB -> MSB
        for(int i = 0;i < ans.length;i++)
            ans[i] = 0;
        for(int i = 0;i < num1.length();i++)
            for(int j = 0;j < num2.length();j++)
                ans[ans.length-i-j-2] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
        for(int i = 0;i < ans.length-1;i++)
            if(ans[i] > 9){
                ans[i+1] += ans[i] / 10;
                ans[i] %= 10;
            }
            
        String res = "";
        for(int i = ans[ans.length-1] != 0 ? ans.length-1 : ans.length-2;i >= 0;i--)
            res += String.valueOf(ans[i]);
        return res;
    }
}
