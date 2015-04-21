package luyna.leetcode.tree;


/**
 * BinaryTree的各种操作，包括求高度、三种深度优先遍历方式（前序、中序、后续的递归和非递归）、层次遍历（宽度优先遍历）
 * Leetcode题目：
 * 1、144 先序遍历二叉树
 * 2、 94  中序遍历二叉树
 * 3、145 后序遍历二叉树
 * 4、102 107 层次遍历二叉树
 * 5、105 先序序列和中序序列重构二叉树
 * 6、106 后序序列和中序序列重构二叉树
 * 
 * 
 * 剑指offer题目：
 * 7、是否包含二叉树
 * 8、二叉树的镜像
 * 
 *  9、Leetcode NO.113找出二叉树中所有和为指定sum的路径（从根节点到叶子节点的所有数值和）
 * 10、Leetcode NO.112 判断二叉树中是否存在和为指定sum的路径
 * 11、Leetcode NO.104 树的最大深度
 * 12、Leetcode NO.111 树的最小深度
 * 13、Leetcode NO.110 剑指offerP209 判断二叉树是否是平衡二叉树
 * @author luyna 2015年1月12日
 * 
 */
import java.util.*;
/**
 * BinaryTree的节点定义
 * 
 */
class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * 
 */
public class BinaryTree {
	private TreeNode root;

	public BinaryTree(TreeNode root) {
		this.root = root;
	}


	/**
	 * leetcode NO.144
	 * 先序遍历树，递归版本
	 * 
	 * @param root
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			// visit(root);
			list.add(root.val);
			list.addAll(preorderTraversal(root.left));
			list.addAll(preorderTraversal(root.right));
		}
		return list;
	}
	/**
	 * 先序遍历树，迭代版本
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){  					//依次遍历并访问所有的左节点，直到左节点为空，
				list.add(visit.val);
				stack.push(visit);				//将遍历的每一个节点存储到栈中
				visit=visit.left;
			}else{                    			//遍历栈订节点的右节点
				visit=stack.pop();
				visit=visit.right;
			}			
		}
		return list;
	}
	/**
	 * leetcode NO.94
	 * 中序遍历树，递归版本
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		if(root!=null){
			list.addAll(inorderTraversal(root.left));
			list.add(root.val);
			list.addAll(inorderTraversal(root.right));
		}
		return list;
	}
	/**
	 * 中序遍历树，迭代版本;
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversalIterative(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){		//先遍历所有左节点，将左节点加入栈中，直到左节点为空
				stack.push(visit);       
				visit=visit.left;
			}else{					//访问栈顶元素，并遍历栈顶元素的右节点
				visit=stack.pop();
				list.add(visit.val); //与前序遍历的区别是该节点访问的位置,先入栈再访问
				visit=visit.right;
			}
		}
		return list;
	}

	/**
	 * leetcode NO.145
	 * 后续遍历树，递归版本
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		if(root!=null){
			list.addAll(postorderTraversal(root.left));
			list.addAll(postorderTraversal(root.right));	
			list.add(root.val);
		}
		return list;
	}
	/**
	 * 
	 * 后续遍历树，迭代版本
	 * 后续遍历的顺序是left->right->root,前序遍历的顺序是root->left->right
	 * 将前序遍历顺序调整成root->right->left，然后倒序输出，即为后序遍历的顺序。
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversalIterative(TreeNode root){
		LinkedList<Integer> list=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){
				list.addFirst(visit.val);   //将每一个数据在头部添加，相当于倒序的效果
				stack.push(visit);
				visit=visit.right;
			}else {
				visit=stack.pop();
				visit=visit.left;
			}
		}
		return list;
	}
	/**
	 * leetcode NO.102
	 * 层次遍历，按层次信息添加到二维列表中
	 * [ [3],[9,20],[15,7]]
	 * 思路：用两个队列存储当前层的节点和下一层的节点，直到当前层节点个数为0
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list=new LinkedList<List<Integer>>();
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //当前层的节点队列
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //当前层节点的值
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//下一层的节点队列
        	for(TreeNode node:currentQueue){
        		currentList.add(node.val);
        		if(node.left!=null) nextQueue.add(node.left);
        		if(node.right!=null) nextQueue.add(node.right);
        	}
        	list.add(currentList);
        	currentQueue=nextQueue;
        }
        return list;
    }
	/**
	 * leetcode NO.107
	 * For example:
	Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
	return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //当前层的节点队列
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //当前层节点的值
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//下一层的节点队列
        	for(TreeNode node:currentQueue){
        		currentList.add(node.val);
        		if(node.left!=null) nextQueue.add(node.left);
        		if(node.right!=null) nextQueue.add(node.right);
        	}
        	list.addFirst(currentList); //与levelOrder()的区别仅在于此，每次在链表头部添加，避免了倒序过程
        	currentQueue=nextQueue;
        }
        return list;
    }

	/**
	 * 5、105 先序序列和中序序列重构二叉树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length ||  preorder.length==0 || inorder.length==0 )
        	return null;
        return buildTreeProcessor(preorder,0,inorder,0,preorder.length);
    }
	/**
	 * 
	 * @param preorder 先序遍历序列数组
	 * @param prestart 先序遍历序列开始下标
	 * @param inorder  中序遍历序列数组
	 * @param instart	中序遍历序列开始下标
	 * @param len		序列长度
	 * @return
	 */
	public TreeNode buildTreeProcessor
	(int[] preorder,int prestart,int[] inorder,int instart,int len){
		if(prestart>preorder.length) return null;
		TreeNode root=new TreeNode(preorder[prestart]);
		int i=0;
		while(i<len){		//找到根节点在中序遍历序列中的位置
			if(preorder[prestart]!=inorder[i+instart]){
				i++;
			}else break;
		}
		if(i>0){		//如果左子树存在，递归构建左子树
			root.left=buildTreeProcessor(preorder, prestart+1,inorder,instart,i);
		}
		if(i<len-1){	//如果右子树存在，递归构建右子树
			root.right=buildTreeProcessor(preorder,prestart+1+i,inorder,instart+i+1,len-i-1);
		}

		return root;
	}
	
	
	/** 
	 * 6、106 后序序列和中序序列重构二叉树
	 */
	
	public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length || inorder.length==0 || postorder.length==0)
        	return null;
        return buildTreePostInProcessor(inorder,inorder.length-1,postorder,postorder.length-1,inorder.length);
    }
	/**
	 * 
	 * @param inorder 
	 * @param instart
	 * @param postorder 后序遍历序列
	 * @param postend  后序遍历序列尾部下标
	 * @param len
	 * @return
	 */
	public static TreeNode buildTreePostInProcessor
	(int[] inorder,int inend,int[] postorder,int postend,int len){
		if(postend<0) return null;
		TreeNode root=new TreeNode(postorder[postend]);
		int i=0;
		//找出中序序列中根节点的位置下标，此处从后往前计数(中序和后序都从后往前遍历)
		/*while(i<len ){    
			if(inorder[i+instart]!=postorder[postend]){
				i++;
			}else break;
		}*/
		while(inend-i>=0){
			if(inorder[inend-i]!=postorder[postend]){
				i++;
			}else break;
		}
		if(i<len-1) root.left=buildTreePostInProcessor(inorder,inend-i-1,postorder,postend-i-1,len-i-1);
		if(i>0) root.right=buildTreePostInProcessor(inorder,inend,postorder,postend-1,i);
		return root;
	}
	
	/**
	 * 8、二叉树的镜像
	 * 思路：先序遍历一棵树，如果遍历到的节点有子节点，就交换它的两个子节点，当
	 * 交换完所有非叶子节点的左右节点后，就得到了它的镜像
	 * @param args
	 */
	public void mirrorRecursively(TreeNode root){
		if(root==null || (root.left==null && root.right==null))
			return ;
		TreeNode tmp=root.left;
		root.left=root.right;
		root.right=tmp;
		if(root.left!=null) mirrorRecursively(root.left);
		if(root.right!=null) mirrorRecursively(root.right);
	}
	
	/**
	 * 9、Leetcode NO.113找出二叉树中所有和为指定sum的路径（从根节点到叶子节点的所有数值和）
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> result=new ArrayList<List<Integer>>();
	    List<Integer> curpath=new ArrayList<Integer>();
	    int [] sumval={sum,0}; //保存期望值和当前值
	    if(root==null) return result;
	    result=pathSumProcessor(root,result,curpath,sum);
	    return result;
	}
	public List<List<Integer>> pathSumProcessor
	(TreeNode root, List<List<Integer>> result,List<Integer> curpath,int sum) {	    
	    curpath.add(root.val);
	    //当前节点为子节点
		if(root.left==null && root.right==null){
			//因为链表都是引用型，后面会对当前路径链表进行修改，所以加入result中的当前路径要保存一个副本
			List<Integer> list=new ArrayList<Integer>(curpath);
	    	if(sum==root.val) result.add(list);	 	    	
	    }
		if(root.left!=null){
			pathSumProcessor(root.left,result,curpath,sum-root.val);
		}
		if(root.right!=null){
			pathSumProcessor(root.right,result,curpath,sum-root.val);
		}
		//当前节点访问结束后，递归函数自动回到它的父节点，所以在函数返回之前要对当前路径做修改
		curpath.remove(curpath.size()-1);
		return result;
	    
	}
	
	/**
	 * 10、Leetcode NO.112 判断二叉树中是否存在和为指定sum的路径
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		if(root.left==null && root.right==null){
			return root.val==sum;
		}
		return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
		//非递归的先序遍历，由于栈的弹出节点可能不是连续的父子节点顺序，所以无法在合适的位置改变cursum值
		/*Stack<TreeNode> stack=new Stack<TreeNode>();
		int cursum=0;
		if(root==null) return false;
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
				cursum +=root.val;
				stack.push(root);
				if(root.left==null && root.right==null){
					if(cursum==sum) return true;
					else cursum -=root.val;
				}
				root=root.left;
			}else{
				root=stack.pop();
				root=root.right;
			}			
		}
        return false;*/
    }
	
	 
	 /**
	  * 11、Leetcode NO.104 树的最大深度
	  * 最大深度指：从根节点到叶子节点的最长路径中的节点数
	  * @param root
	  * @return
	  */
	 public int maxDepth(TreeNode root) {
	     if(root==null) return 0;
	     int left=maxDepth(root.left)+1;
	     int right=maxDepth(root.right)+1;
	     return left>right?left:right;
	 }
	 /**
	  * 12、Leetcode NO.111 树的最小深度
	  * 最小深度是指：从根节点到叶子节点最短路径中的节点数
	  * @param root
	  * @return
	  */
	 public int minDepth(TreeNode root) {
		 if(root==null) return 0;
		 int left=minDepth(root.left);
		 int right=minDepth(root.right);
		 if(left==0 && right!=0) return right+1;
		 else if(left!=0 && right==0) return left+1;
	     return left<right?left+1:right+1;
	 }
	 
	
	 /**
	  * 13、Leetcode NO.110 剑指offerP209 判断二叉树是否是平衡二叉树
	  * 思路一：用递归的思想判断左右子树的高度差是否大于1
	  * 缺点：重复计算
	  * @param root
	  * @return
	  */
	/* public boolean isBalanced(TreeNode root) {
	     if(root==null) return true;   
	     int left=maxDepth(root.left);
	     int right=maxDepth(root.right);
	     int diff=left-right;
	     if(diff>1 || diff<-1) return false;
	     return isBalanced(root.left) && isBalanced(root.right);
	 }*/
	 /**
	  * 13、思路二：遍历每个节点时记录下节点的深度，从下往上计算
	  * 备忘录思想
	  * @param root
	  * @return
	  */
	 public boolean isBalanced(TreeNode root) {
		 return isBalancedHelper(root)!=-1;
	 }
	 /**
	  * 从下向上遍历计算
	  * @param root
	  * @return 若平衡，返回节点所在的高度；若不平衡，返回-1
	  */
	 public int isBalancedHelper(TreeNode root){
		 if(root==null) {
			 return 0;
		 }
		 int left=isBalancedHelper(root.left);
		 if(left==-1) return -1;  //若左子树不平衡，返回-1
		 int right=isBalancedHelper(root.right);
		 if(right==-1) return -1; //若右子树不平衡，返回-1
		 //若左右子树都平衡，则判断当前节点是否平衡
		 int diff=left-right;
		 if(diff>1 || diff<-1) return -1;
		 else return diff>0?left+1:right+1;
	 }
	 
	 
	public static void main(String [] args){
		int[] inorder={1,2,3,4};
		int[] postorder={1,3,4,2};
		buildTreePostIn(inorder,postorder);
	}
	
}




