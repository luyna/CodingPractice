package luyna.leetcode.tree;
/**
 * 关于二叉搜索树的面试题
 * 1、剑指offer P140 根据输入数组判断该数组是不是某二叉搜索树后序遍历的有效序列
 * 2、二叉搜索树转换成双向链表
 * @author luyna
 * 2015年1月15日
 */
public class BinarySearchTree {
	/**
	 * 1、剑指offer P140 根据输入数组判断该数组是不是某二叉搜索树后序遍历的有效序列
	 * 假设输入的数组中各元素互不相同
	 * 思路：最后一个元素是根节点，前半部分小于根节点的元素是左子树，后半部分大于根节点的元组是右子树
	 * 如果右子树中有元素小于根节点，则该序列是无效的
	 * 测试用例：
	 * [5,7,6,9,11,10,8] 完全二叉搜索树
	 * [1,2,3] 只有左子树
	 * [4,3,2] 只有右子树
	 * [1] 只有一个节点
	 * [7,4,6,5] 没有对应的二叉搜索树
	 * [] 空
	 * @param postorder 
	 * @return
	 */
	public boolean validSeq(int [] postorder){
		if(postorder.length==0 || postorder==null) return false;
		return verifySeqOfBST(postorder,0,postorder.length-1);
	}
	/**
	 * 
	 * @param postorder
	 * @param start  子序列的开始下标
	 * @param end	   子序列的结束下标
	 * @return
	 */
	public boolean verifySeqOfBST(int [] postorder,int start,int end){	
		if(start==end) return true;  //只有一个节点时成立
		int root=postorder[end];
		//找出左子树的元素个数
		int i=start;
		for(;i<end;i++){
			if(postorder[i]>root)
				break;
		}
		//如果右子树中有元素小于root则为false
		int j=i;
		for(;j<end;j++){
			if(postorder[j]<root)
				return false;
		}
		
		boolean leftresult=true,rightresult=true;
		//判断左子树序列是不是有效的二叉搜索树
		if(i>0)
			leftresult=verifySeqOfBST(postorder,start,i-1);//注意下标的指针，此处end=i-1,而不是start+i-1
		//判断右子树序列是不是有效的二叉搜索树
		if(i<end)
			rightresult=verifySeqOfBST(postorder,i,end-1);
		return leftresult&&rightresult;
	}
	
	public static void main(String[] args){
		int [] seq1={5,7,6,9,11,10,8};
		int [] seq2={1,2,3};
		int [] seq3={4,3,2};
		int [] seq4={1};
		int [] seq5={7,4,6,5};
		int [] seq6={};
		BinarySearchTree tree=new BinarySearchTree();
		System.out.println("seq1:"+tree.validSeq(seq1));
		System.out.println("seq2:"+tree.validSeq(seq2));
		System.out.println("seq3:"+tree.validSeq(seq3));
		System.out.println("seq4:"+tree.validSeq(seq4));
		System.out.println("seq5:"+tree.validSeq(seq5));
		System.out.println("seq6:"+tree.validSeq(seq6));
	}
	
	
}
