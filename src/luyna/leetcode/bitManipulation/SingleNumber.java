package luyna.leetcode.bitManipulation;
/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * @author luyna
 *
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
        int result=A[0];
        int i=1;
        while(i<A.length){
        	result=result^A[i];
        	i++;
        }
        return result;
    }
}
