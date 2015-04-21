package luyna.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
	public int[] insertSort(int [] A){
		if(A==null || A.length==0 || A.length==1) return A;
		for(int i=1;i<A.length;i++){
			int j=i-1;
			int tmp=A[i];
			while(j>=0 && tmp<A[j]) {
				A[j+1]=A[j];
				j--;
			}
			A[j+1]=tmp;
		}
		return A;
	}
	public static void main(String [] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		int [] test5={10,4,8,9};
		int [] test6={2,3,4,5,6};
		int [] test7={6,5,4,3,2,1};
		InsertSort sort=new InsertSort();
		System.out.println("！！！！！！！！ InsertSort test！！！！！！！！");
		System.out.println("test1"+Arrays.toString(sort.insertSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.insertSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.insertSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.insertSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.insertSort(test5)));
		System.out.println("test6"+Arrays.toString(sort.insertSort(test6)));
		System.out.println("test7"+Arrays.toString(sort.insertSort(test7)));
	}
}
