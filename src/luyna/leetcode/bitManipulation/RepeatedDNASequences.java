package luyna.leetcode.bitManipulation;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.Write a function to find all 
 * the 10-letter-long sequences (substrings) that occur more than once in a 
 * DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author luyna
 *
 */
public class RepeatedDNASequences {
	/**
	 * 比较笨的思路：将字符串中大小为10的字串存入哈希表中，如果哈希表中已经存在某个字串，则说明该字串不止出现一次
	 * 执行情况：占用内存较多  Memory Limit Exceeded
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<String>();
        Set<String> result=new HashSet<String>();
        int i=0,len=s.length();
        while(i<=len-10){
        	String tmp=s.substring(i,i+10);
        	if(set.contains(tmp)) result.add(tmp);
        	else set.add(tmp);
        	i++;
        }
        //之所以先用hashset来保存结果字符串，是希望多个重复的相同字串只保存一次。
        List<String> list=new LinkedList<String>();
        list.addAll(result);
        return list;
    }
	/**
	 * 另外一种方法是用rolling hash算法，占坑以后填
	 * @param s
	 * @return
	 */
	/*public List<String> findRepeatedDnaSequences(String s) {
        
        return list;
    }*/
	
	
	public static void main(String[] args){
		String s="aaaaaaaaaaaa";
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
	}
}
