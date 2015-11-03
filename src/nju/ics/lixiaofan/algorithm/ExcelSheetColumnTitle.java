package nju.ics.lixiaofan.algorithm;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle a = new ExcelSheetColumnTitle();
		System.out.println(a.convertToTitle(1));
	}
    public String convertToTitle(int n) {
        if(n < 1)
            return null;
        String title = "";
        while(n > 0){
            title = String.valueOf((char)('A'+(n-1)%26)) + title;
            n = (n-1)/26;
        }
        return title;
    }
}
