package luyna.leetcode.bitManipulation;

import java.util.*;
/**
 * Given a set of distinct integers, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author luyna
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S); //因为要求每个子集合以非递减显示，所以先将数据排序
        int bitSize=S.length;
        int len=(int) Math.pow(2, bitSize);
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        for(int i=0;i<len;i++){
        	List<Integer> tmp=new LinkedList<Integer>();
        	int j=0;
        	while(j<bitSize){
        		if((i&(1<<j)) != 0){ //&操作要放在括号里
        			tmp.add(S[j]);
        		}
        		j++;
        	}
        	result.add(tmp);
        }
        return result;
    }
	
	public static void main(String[] args){
		int [] s={4,1,0};
		System.out.println(new Subsets().subsets(s));
	}
}
