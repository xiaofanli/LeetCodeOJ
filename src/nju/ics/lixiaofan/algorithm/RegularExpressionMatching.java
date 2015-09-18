package nju.ics.lixiaofan.algorithm;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
*/
public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StringBuffer newp = new StringBuffer("a*aaabbb*bbbbbcc*cdaa*");
//		int idx = newp.indexOf("*");
//		while(idx < newp.length()-1 && idx > 0){			
//			
//			if(newp.charAt(idx-1) == newp.charAt(idx+1)){
//				int tmp = idx + 2;
//				while(tmp < newp.length() && newp.charAt(tmp) == newp.charAt(idx-1))
//					tmp++;
//				newp.setCharAt(idx, newp.charAt(idx-1));
//				newp.setCharAt(tmp-1, '*');
//				idx = tmp;
//			}
//			if(idx < newp.length()-1)
//				idx += newp.substring(idx).indexOf("*");
//		}
//		System.out.println(newp);
		
//		String[] strs = "c*asd.*h*asdh*".split(".\\*");
//		for(String s : strs)
//			System.out.println(s);
//		System.out.println(strs.length);
//		System.out.println(isMatch("aaa","ab*a*c*a"));
	}

	public boolean isMatch(String s, String p)
	{
	    return matchRecursive(s.toCharArray(), 0, p.toCharArray(), 0    );
	}

    public static boolean matchRecursive(char[] s, int ptr, char[] p, int ptrP) {
        if (ptr == s.length && ptrP == p.length) return true;

        if (ptrP <= p.length-2 && p[ptrP+1] == '*') {
            if (matchDigit(s,ptr,p,ptrP)) {
                     boolean result = false;

                // consume this digit, the * is still valid
                result = matchRecursive(s, ptr+1, p, ptrP);

                if (result) return true;
                // this digit can't align with pattern, have to ignore the * section
                return matchRecursive(s, ptr, p, ptrP+2);
            } else return matchRecursive(s, ptr, p, ptrP+2);

        }
        else return matchDigit(s, ptr, p, ptrP) && matchRecursive(s, ptr+1, p, ptrP+1);
    }

    public static boolean matchDigit(char[]s, int ptr, char[] p, int ptrP) {
        if (ptr == s.length || ptrP == p.length ) return false;
        if (p[ptrP] == '.') return true;
        if (p[ptrP] == s[ptr]) return true;
        return false;
    }
}
