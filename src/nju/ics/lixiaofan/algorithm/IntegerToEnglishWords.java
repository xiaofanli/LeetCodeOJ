package nju.ics.lixiaofan.algorithm;
/*Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)*/
public class IntegerToEnglishWords {
    String[] words = {null, "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {null, null, "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] magnitude = {null, "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        String result = null;
        int cnt = 0;
        while(num > 0){
            String s = null;
            int tmp = num % 1000;
            if(tmp >= 100){
                s = words[tmp/100] + " Hundred";
                tmp %= 100;
            }
            if(tmp > 0){
                if(tmp < 20)
                        s = (s != null) ? (s + " " + words[tmp]) : words[tmp];
                else{
                    s = (s != null) ? (s + " " + tens[tmp/10]) : tens[tmp/10];
                    tmp %= 10;
                    if(tmp > 0)
                        s += " " + words[tmp];
                }
            }
            if(s != null){
                if(cnt > 0)
                    s += " " + magnitude[cnt];
                result = (result != null) ? (s + " " + result) : s;
            }
            num /= 1000;
            cnt++;
        }
        return result != null ? result : "Zero";
    }
}
