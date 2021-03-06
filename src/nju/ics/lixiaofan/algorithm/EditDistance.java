package nju.ics.lixiaofan.algorithm;
/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance {
	//DP solution
	//dis[i][j] means the minimum distance required to convert first i characters of word1 to first j characters of word2
    public int minDistance(String word1, String word2) {
        int[][] dis = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i < dis[0].length;i++)
            dis[0][i] = i;
        for(int i = 0;i < dis.length;i++)
            dis[i][0] = i;
        
        for(int i = 1;i < dis.length;i++)
            for(int j = 1; j < dis[0].length;j++)
                dis[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dis[i-1][j-1] : 
                    Math.min(dis[i-1][j-1], Math.min(dis[i][j-1], dis[i-1][j])) + 1;
        
        return dis[word1.length()][word2.length()];
    }
}
