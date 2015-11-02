package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        String line = "";
        int i = 0, j = i, width;
        while(i < words.length){
            width = words[j++].length();
            while(j < words.length && width+words[j].length()+1 <= maxWidth)
                width += words[j++].length() + 1;
            //the last line or only one word
            if(j == words.length || j-i == 1){
                line = words[i++];
                while(i < j)
                    line += " " + words[i++];
                line += new String(new char[maxWidth-line.length()]).replace("\0"," ");
                result.add(line);
            }
            else{
                int spaces = maxWidth - width;
                int slots = j - i - 1;
                int avg = spaces / slots, extra = spaces - avg * slots;
                String space = new String(new char[avg+1]).replace("\0"," ");
                line = words[i++];
                while(i < j){
                    line += space;
                    if(extra > 0){
                        line += " ";
                        extra--;
                    }
                    line += words[i++];
                }
                result.add(line);
            }
        }
        return result;
    }
}
