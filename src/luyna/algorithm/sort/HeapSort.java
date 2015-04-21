package luyna.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
	/**
	 * 调整堆，堆顶位于下标i的位置
	 * @param A
	 * @param i
	 * @param heapSize
	 */
	public void maxHeapify(int []A,int i,int heapSize){
		int left=getLeftChildIndex(i);
		int right=getRightChildIndex(i);
		int largest=i;
		if(left<heapSize && A[i]<A[left]) largest=left;
		if(right<heapSize && A[largest]<A[right]) largest=right;  //注意一定是A[largest]与A[right]比较，而不是 A[i]与A[right]比较
		if(largest != i){
			int tmp=A[largest];
			A[largest]=A[i];
			A[i]=tmp;
			maxHeapify(A,largest,heapSize);  
		}
	}
	/**
	 * 从下往上调整堆（A.legth/2->0）
	 * @param A
	 */
	public void BuildMaxHeap(int[] A){
		int len= getParentIndex(A.length-1);
		for(int i=len;i>=0;i--){
			maxHeapify(A,i,A.length);
		}
	}
	
	public int[] heapSort(int [] A){
		BuildMaxHeap(A);
		for(int i=A.length-1;i>0;i--){
			//交换A[0]和A[i]
			int tmp=A[0];
			A[0]=A[i];
			A[i]=tmp;
			maxHeapify(A,0,i);
		}
		return A;
	}
	
	public int getLeftChildIndex(int i){
		return (i<<1)+1;
	}
	public int getRightChildIndex(int i){
		return (i<<1)+2;
	}
	public int getParentIndex(int i){
		return (i-1)>>1;
	}
	
	public static void main(String [] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		int [] test5={10,4,8,9};
		int [] test6={2,3,4,5,6};
		int [] test7={6,5,4,3,2,1};
		HeapSort sort=new HeapSort();
		System.out.println("————————heapSort test————————");
		System.out.println("test1"+Arrays.toString(sort.heapSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.heapSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.heapSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.heapSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.heapSort(test5)));
		System.out.println("test6"+Arrays.toString(sort.heapSort(test6)));
		System.out.println("test7"+Arrays.toString(sort.heapSort(test7)));
		
	}

}

