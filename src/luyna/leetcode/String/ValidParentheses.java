package luyna.leetcode.String;

import java.util.HashMap;
import java.util.LinkedList;
/**
 * ≈–∂œ¿®∫≈¥Æ «∑Ò”––ß
 * @author luyna
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if(s.isEmpty()|| s==null) return true;
		if(s.length()==1) return false;
        HashMap<Character,Character> pair=new HashMap<Character,Character>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');
        LinkedList<Character> stack=new LinkedList<Character>();
        if(!pair.containsKey(s.charAt(0))) return false;
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
        	if(!stack.isEmpty() && s.charAt(i)==pair.get(stack.peek())){
        		stack.pop();
        	}else {
        		if(!pair.containsKey(s.charAt(i))) return false;
        		stack.push(s.charAt(i));
        	}
        }
        if(stack.isEmpty()) return true;
        else return false;    
    }
	
	public static void main(String[] args){
		System.out.println(new ValidParentheses().isValid(")}{({))[{{[}"));
	}
}
