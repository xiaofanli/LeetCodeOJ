package nju.ics.lixiaofan.algorithm;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath a = new SimplifyPath();
		System.out.println(a.simplifyPath("/.."));
	}
    public String simplifyPath(String path) {
        if(path == null)
            return null;
        Stack<String> dir = new Stack<String>();
        char[] p = path.toCharArray();
        int i = 0;
        while(i < p.length){
            do{
                i++;
            }while(i < p.length && p[i] == '/');
            
            int begin = i;
            boolean isFile = false;
            while(i < p.length && p[i] != '/'){
                if(p[i] != '.')
                    isFile = true;
                i++;
            }
            if(i > begin){
                if(isFile || i-begin > 2)
                    dir.push(String.valueOf(p, begin, i-begin));
                else
                    for(int j = 0;j < i-begin-1;j++)
                        if(dir.isEmpty())
                            break;
                        else
                            dir.pop();
            }
        }
        if(dir.isEmpty())
            return "/";
            
        path = "";
        while(!dir.isEmpty()){
            path = "/" + dir.pop() + path;
        }
        return path;
    }
}
