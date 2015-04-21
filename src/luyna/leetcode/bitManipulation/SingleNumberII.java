package luyna.leetcode.bitManipulation;
/**
 * Given an array of integers, every element appears three times except for one.
 *  Find that single one.
 *  Note:
 *  Your algorithm should have a linear runtime complexity.
 *  Could you implement it without using extra memory?
 *   
 * @author luyna
 *
 */
public class SingleNumberII {
	/**
	 * 方法一：统计数组中每个数字第i位出现1的个数，将所有1的个数保存在数组中，
	 * 1的个数%3的余数（0或者1）就是只出现一次的数字相应位的值
	 * 时间复杂度O(n)
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
        int []countOnes=new int[32];
        int result=0;
        for(int i=31;i>=0;i--){
        	for(int j=0;j<A.length;j++){
        		if((A[j] & (1<<i))!=0){
        			countOnes[i]++;
        		}
        	}
        	result=result*2+countOnes[i]%3;       	
        }
        return result;
    }
}
