package luyna.leetcode.array;


import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 数组循环右移k位。
 * 注意判断k的边界
 * @author luyna
 * 2015年3月7日
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
        if(nums.length==0 || nums==null) return;
        if(k<0) return;
        if(k>=nums.length) k=k%nums.length;
        rotateHelper(nums,0,nums.length-1);
        rotateHelper(nums,0,k-1);
        rotateHelper(nums,k,nums.length-1);
    }
	public void rotateHelper(int [] nums,int i,int j ){
		if(i==j ) return;
		while(i<j){
			int tmp=nums[i];
			nums[i]=nums[j];
			nums[j]=tmp;
			i++;
			j--;
		}
	}
	
	public static void main(String [] args){
		RotateArray test=new RotateArray();
		int [] A=new int[]{1,2,3,4,5,6,7};
		test.rotate(A, 12);
		System.out.println(Arrays.toString(A));
	}
}
