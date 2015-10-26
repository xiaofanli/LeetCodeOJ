package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        Set<String> result = new HashSet<String>();
        boolean[][] used = new boolean[board.length][board[0].length];
        
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.child[c-'a'] == null)
                    node.child[c-'a'] = new TrieNode();
                node = node.child[c-'a'];
            }
            node.word = word;
        }
        
        for(int i = 0;i < board.length;i++)
            for(int j = 0;j < board[0].length;j++)
                if(root.child[board[i][j]-'a'] != null)
                    dfs(i, j, root, board, used, result);
        
        return new LinkedList<String>(result);
    }
    
    private void dfs(int i, int j, TrieNode node, char[][] board, boolean[][] used, Set<String> result){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j])
            return;
        if(node.child[board[i][j]-'a'] == null)
            return;
        
        used[i][j] = true;
        node = node.child[board[i][j]-'a'];
        if(node.word != null)
            result.add(node.word);
        
        dfs(i-1, j, node, board, used, result);
        dfs(i+1, j, node, board, used, result);
        dfs(i, j-1, node, board, used, result);
        dfs(i, j+1, node, board, used, result);
    
        used[i][j] = false;       
    }
    
    private class TrieNode{
        String word = null;
        TrieNode[] child = new TrieNode[26];
    }
}
