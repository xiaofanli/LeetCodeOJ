package nju.ics.lixiaofan.algorithm;
/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or ..
A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0;i < word.length();i++){
            if(node.child[word.charAt(i)-'a'] == null)
                node.child[word.charAt(i)-'a'] = new TrieNode();
            node = node.child[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode node){
        if(word == null)
            return node.isWord;
        for(int i = 0;i < word.length();i++)
            if(word.charAt(i) == '.'){
                String str = word.substring(i+1);
                for(TrieNode n : node.child)
                    if(n != null && search(str, n))
                        return true;
                return false;        
            }
            else if(node.child[word.charAt(i)-'a'] != null)
                    node = node.child[word.charAt(i)-'a'];
            else
                return false;
        
        return node.isWord;
    }
    
    private class TrieNode{
        boolean isWord = false;
        TrieNode[] child = new TrieNode[26];
    }
}
