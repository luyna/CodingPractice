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
	 * �Ƚϱ���˼·�����ַ����д�СΪ10���ִ������ϣ���У������ϣ�����Ѿ�����ĳ���ִ�����˵�����ִ���ֹ����һ��
	 * ִ�������ռ���ڴ�϶�  Memory Limit Exceeded
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
        //֮��������hashset���������ַ�������ϣ������ظ�����ͬ�ִ�ֻ����һ�Ρ�
        List<String> list=new LinkedList<String>();
        list.addAll(result);
        return list;
    }
	/**
	 * ����һ�ַ�������rolling hash�㷨��ռ���Ժ���
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
