package nju.ics.lixiaofan.algorithm;

/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    // the straightforward solution is in O(N^2); using KMP's preprocessing algorithm,
    // we can reduce this to O(N)
	private int longestPalindromePrefix(String s){
    /**
     * The LPS computation can determine, at any given index i in a string S, the maximum suffix length that
     * make up a suffix equal to the prefix. For example: S = "acexxxaceyyy": at S[6], S[7], and S[8] will be
     * marked with "1", "2", and "3" respectively because "a", "ac", and "ace" at this points in the string
     * make up substrings whose suffixes equal to the string's prefix. This computation can be done in one
     * linear scan of the string in O(N) time, using a secondary integer array in O(N) space.
     * 
     * For our purpose in finding the longest palindrome prefix of a string, the idea is simple:
     * if we reverse the string, then appending it to the original string (after a special marker),
     * the palindromic prefix will show up at the end of the compound string! If we then apply the above algorithm,
     * by the end of the linear scan, we'll have a number that correspond to the maximum suffix length of
     * the entire compound string, which correspond to a suffix = prefix. And since a palindromic prefix, when
     * reversed and appended, will show up as the suffix, we will conveniently have computed the maximum
     * length of the palindromic prefix!
     * 
     * For example: consider the string S = "abbaaax". The longest palindrome prefix is "abba".
     * 1. Create S' = "abbaaax#xaaabba"
     * 2. Compute LPS: lps[] = { 0,  0,  0,  1,  1,  1,  0,  0,  0,  1,  1,  1,  2,  3,  4 }
     *            from  S'[] = {'a','b','b','a','a','a','x','#','x','a','a','a','b','b','a'}
     * 3. The last element of LPS, 4, is our longest palindrome prefix length!
     */
        String kmprev = new StringBuilder(s).reverse().toString();
        char[] kmp = (s + "#" + kmprev).toCharArray();

        int[] lps = new int[kmp.length];   // lps[i] = longest suffix length for substring kmp[0..i] where the suffix == prefix
        for (int i = 1; i < lps.length; ++i){
            int prevIdx = lps[i - 1];
            while (prevIdx > 0 && kmp[i] != kmp[prevIdx]){
                prevIdx = lps[prevIdx - 1];
            }

            lps[i] = prevIdx + (kmp[i] == kmp[prevIdx] ? 1 : 0);
        }

        // after KMP's LPS preprocessing, the last index of the LPS array will contain the longest palindrome prefix' length!
        return lps[lps.length - 1];
    }

	public String shortestPalindrome(String s){
        //
        // The idea is simple: find the longest palindrome that prefixes the string S.
        // The shortest palindrome we can make is by reversing the rest of the string S, and then
        // prepending it to the string.
        //
        // The trick is finding that longest palindrome prefix in an efficient manner.
        //
        if (s.length() <= 1)
            return s;

        int k = longestPalindromePrefix(s);

        String rest = new StringBuilder(s.substring(k)).reverse().toString();
        return rest + s;
    }
}
