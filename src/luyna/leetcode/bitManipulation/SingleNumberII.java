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
	 * ����һ��ͳ��������ÿ�����ֵ�iλ����1�ĸ�����������1�ĸ��������������У�
	 * 1�ĸ���%3��������0����1������ֻ����һ�ε�������Ӧλ��ֵ
	 * ʱ�临�Ӷ�O(n)
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
