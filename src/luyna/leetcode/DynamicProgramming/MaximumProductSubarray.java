package luyna.leetcode.DynamicProgramming;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
        return maxProductHelper(A,0,A.length-1);
    }
	
	public int maxProductHelper(int[] A,int i,int j){
		if(i==j) return A[i];
		int leftmax=maxProductHelper(A,i+1,j);
		int rightmax=maxProductHelper(A,i,j-1);
		return Math.max((A[i]*leftmax<0?1:leftmax)*A[i],(A[j]*rightmax<0?1:rightmax)*A[j]);
	}
	
	public static void main(String[] args){
		MaximumProductSubarray test=new MaximumProductSubarray();
		int[] A={2,4,-3,2};
		System.out.println(test.maxProduct(A));
	}
}
