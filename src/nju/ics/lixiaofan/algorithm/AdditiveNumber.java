package nju.ics.lixiaofan.algorithm;
/*Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?*/
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if(num == null)
            return false;
        int len = num.length(), len1 = len - 1;
        if(len < 3)
            return false;
        char[] carray = num.toCharArray();
        int bound = (len + 1) / 2, bound2, a, b, c = len, idx;
        for(int i = len1;i >= bound;i--){
            if(i < len1 && carray[i] == '0') //leading zero
                continue;
            b = i;
            bound2 = 2 * i - len;
            for(int j = i-1;j >= bound2;j--){
                if(j < i - 1 && carray[j] == '0') //leading zero
                    continue;
                a = j;
                while((idx = getSuffix(carray, a, b, c)) >= 0){
                    if(idx == 0)
                        return true;
                    c = b;
                    b = a;
                    a = idx;
                }
                b = i;
                c = len;
            }
        }
        return false;
    }
    
    private int getSuffix(char[] num, int a, int b, int c){
//    	System.out.println(String.valueOf(num, 0, a) + " " + String.valueOf(num, a, b-a) + " " + String.valueOf(num, b, c-b));
        boolean borrow = false, leadingZero = false;
        int i = a - 1, j = b - 1, k = c - 1, x, y, z, zeros = 0; 
        while(k >= b){
            z = num[k--] - '0';
            if(borrow)
                z--;
            y = j >= a ? num[j--] - '0' : 0;
            if(z < y){
                borrow = true;
                z += 10;
            }
            else
                borrow = false;
            if(y != z){
                if(leadingZero && zeros > 0){
                    while(i >= 0 && zeros > 0){
                        if(num[i--] != '0')
                            return -1;
                        zeros--;
                    }
                    if(zeros > 0)
                        return -1;
                }
                if(i < 0)
                	return -1;
                x = num[i--] - '0';
                if(x + y != z)
                    return -1;
                leadingZero = false;
                zeros = 0;
            }
            else if(leadingZero)
                zeros++;
            else{
                if(i == a - 1){
                    if(num[i--] != '0')
                        return -1;
                    leadingZero = true;
                }
                else{
                    leadingZero = true;
                    zeros++;
                }
            }
        }
        
        return i + 1;
    }
}
