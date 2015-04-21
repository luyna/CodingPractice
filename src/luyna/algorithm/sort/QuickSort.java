package luyna.algorithm.sort;

import java.util.Arrays;
/**
 * 快速排序时间复杂度：最坏O(n^2) 最好O(nlgn)
 * 空间复杂度：O(n) O(lgn) 递归栈
 */
public class QuickSort {
	public int[] quickSort(int [] A){
		if(A==null || A.length==0 || A.length==1) return A;
		partition(A,0,A.length-1);
		return A;
	}
	/**
	 * 分区算法，将数组分成两个子数组，左边元素小于等于pivot，右边元素大于pivot
	 * @param A
	 * @param i 数组开始位置
	 * @param j 数组结束位置
	 */
	public void partition(int [] A,int i,int j){
		int pivot=A[i];
		int start=i;
		int end=j;
		while(i<j){
			while(i<j && A[j]>pivot) j--; //从右边找第一个小于等于pivot的值
			A[i]=A[j]; 
			while(i<j && A[i]<=pivot) i++;  //从左边找到第一个大于pivot的值
			A[j]=A[i];   //最后空下来的是i位
		}
		A[i]=pivot;
		if(i-1>start) partition(A,start,i-1);
		if(i+1<end) partition(A,i+1,end);

	}
	
	public static void main(String[] args){
		QuickSort sort=new QuickSort();
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		int [] test5={10,4,8,9};
		int [] test6={2,3,4,5,6};
		int [] test7={6,5,4,3,2,1};
		System.out.println("———————— QuickSort test————————");
		System.out.println("test1"+Arrays.toString(sort.quickSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.quickSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.quickSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.quickSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.quickSort(test5)));
		System.out.println("test6"+Arrays.toString(sort.quickSort(test6)));
		System.out.println("test7"+Arrays.toString(sort.quickSort(test7)));
	}
}
