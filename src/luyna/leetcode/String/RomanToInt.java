package luyna.leetcode.String;

import java.util.HashMap;
/**
 * 将罗马数字转换成整数
 * 从右往左遍历罗马字符串，假设当前处理i位字符，如果i-1位的数字小于i位数字数字，则结果减去i-1位数字；
 * 否则加上第i位数字。
 * @author luyna
 *
 */
public class RomanToInt {
	public int romanToInt(String s) {
		if(s.length()==0) return 0;
        HashMap<Character,Integer> base=new HashMap<Character,Integer>();
        base.put('I', 1);
        base.put('V', 5);
        base.put('X', 10);
        base.put('L', 50);
        base.put('C', 100);
        base.put('D', 500);
        base.put('M', 1000);
        int result=base.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
        	if(base.get(s.charAt(i))<base.get(s.charAt(i+1))){
        		result -= base.get(s.charAt(i));
        	}else result +=base.get(s.charAt(i));
        }
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(new RomanToInt().romanToInt("XIII"));
	}
}
