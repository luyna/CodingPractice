package luyna.leetcode.linkedlist;

import java.util.*;


/**
 *1、 剑指offer：将链表中所有元素反转
 *2、Leetcode NO.92  反转链表中部分元素 
 *3、Leetcode NO.21  将两个已排序的链表合并成一个链表
 *4、Leetcode NO.2 计算两个数的和，这两个数是用链表反向表示的
 *	如：Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *5、Leetcode NO.23  合并K个有序链表成一个有序链表（未完）
 *6、Leetcode NO.25 Reverse Nodes in k-Group
 * @author luyna
 * 2015年1月14日
 */
public class LinkedListOperation {
	/**
	 * 剑指offer：将链表中所有元素反转
	 * 测试用例：
	 * []
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head){
		if(head==null || head.next==null) return head;
		
		ListNode node=head;
		ListNode prevNode=null;
		ListNode nextNode=null;
		while(node!=null){
			nextNode=node.next;
			node.next=prevNode;
			prevNode=node;
			node=nextNode;		
		}
		return prevNode;
		
	}
	/**
	 * Leetcode NO.92  反转链表中部分元素（m,n）之间
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * Given m, n satisfy the following condition:
	 * 1 ≤ m ≤ n ≤ length of list.
	 * 思路：先反转m到n之间的节点，并保存m前和n后的节点:1->2<-3<-4->5->NULL
	 * 然后设置子链表的前和后面的节点：1->4->3->2->5->NULL.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null || m>=n) return head;
		ListNode top=head,//若m=1，则top保存head,否则保存m前的一个节点
				node=head;
		ListNode preNode=null;
		ListNode nextNode=null;
		int i=1;
		while(i<m){  //若写成i++<m（先判断再加加，不管判读成立与否，都执行++运算）是错误的，因为下面要用到i的值，当i<m不成立时，i++<m仍会计算i++
			top=node;
			node=node.next;	
			i++;
		}
		preNode=node;
		node=node.next;
		while(i<n){
			nextNode=node.next;
			node.next=preNode;
			preNode=node;
			node=nextNode;
			i++;
		}
		if(m==1) {
			head.next=node;
			return preNode;
		}
		ListNode tmp=top.next;
		top.next=preNode;
		tmp.next=nextNode;
		return head;
	}
	/**
	 * Leetcode NO.21  将两个已排序的链表合并成一个链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode head=null;
        if(l1.val<=l2.val) {
        	head=l1;
        	l1=l1.next;
        }else{
        	head=l2;
        	l2=l2.next;
        }
        ListNode p=head;
        while(l1!=null && l2!=null){
        	if(l1.val<=l2.val){
        		p.next=l1;
        		l1=l1.next;
        	}else{
        		p.next=l2;
        		l2=l2.next;
        	}
        	p=p.next;
        }
        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;
        return head;
    }
	
	
	 /**
	  *4、Leetcode NO.2 计算两个数的和，这两个数是用链表反向表示的
	  *	如：Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	  * @param l1
	  * @param l2
	  * @return
	  */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    return addTwoNumbersHelper(l1,l2,0);
	}
	
	public ListNode addTwoNumbersHelper(ListNode l1,ListNode l2,int carry){
		if(l1==null){
			return carry==0?l2:addTwoNumbersHelper(new ListNode(carry),l2,0);
		}
		if(l2==null){
			return carry==0?l1:addTwoNumbersHelper(l1,new ListNode(carry),0);
		}
		
		int sum=l1.val+l2.val+carry;
		ListNode newnode=new ListNode(sum%10);
		newnode.next=addTwoNumbersHelper(l1.next,l2.next,sum/10);
		return newnode;
	}
	/**
	 * 5、Leetcode NO.23  合并K个有序链表成一个有序链表
	 * 不能用TreeSet保存数据，因为它不能含有重复数字；TreeSet中保存的数据必须实现Comparator接口或者为TreeSet设置比较器
	 * java.util.ConcurrentModificationException异常：
	 * 		用lists.remove(ListNode)方法会抛出此异常，所以一般用迭代器的remove方法
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode head=null;
		//将lists中为空的链表去除掉
		/*for(ListNode node:lists){
			if(node==null ) lists.remove(node);//java.util.ConcurrentModificationException异常 
		}*/
		/*Iterator<ListNode> itr=lists.iterator();
		while(itr.hasNext()){
			if(itr.next()==null) 
				itr.remove();
		}
		if(lists==null || lists.size()==0) return head;	
		Comparator comparator=new ListNodeComparator(); //treeSet需要设置比较器
        TreeSet<ListNode> set=new TreeSet<ListNode>(comparator);
        set.addAll(lists);
        head=set.pollFirst();
        if(head.next!=null) set.add(head.next);
        ListNode tmp=head;
        while(!set.isEmpty()){
        	ListNode smallest=set.pollFirst();
        	tmp.next=smallest;
        	if(smallest.next!=null){
        		set.add(smallest.next);	
        	}
        	tmp=tmp.next;       	
        }
        System.out.println("test");*/
        return head;
    }
	/**
	 * 6、Leetcode NO.25 Reverse Nodes in k-Group
	 * For example,
	 * Given this linked list: 1->2->3->4->5
	 * 	For k = 2, you should return: 2->1->4->3->5
	 * 	For k = 3, you should return: 3->2->1->4->5
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || head.next==null || k<=1) return head;
	    ListNode node1=head,node2=head;
	    int i=k;
	    while(i-- >0){
	    	if(node2==null) return head;
	    	node2=node2.next;
	    }
	    //递归反转
	    ListNode nextnode=null,prenode=reverseKGroup(node2,k);
	    while(k-- >0){
	    	nextnode=node1.next;
	    	node1.next=prenode;
	    	prenode=node1;
	    	node1=nextnode;
	    	
	    }
	    return prenode;
	}
	
	public static void main(String[] args){
		/*List<ListNode> list=new LinkedList<ListNode>();
		ListNode head1=new ListNode(1);
		head1.next=new ListNode(2);
		head1.next.next=new ListNode(2);
		ListNode head2=new ListNode(1);
		head2.next=new ListNode(1);
		head2.next.next=new ListNode(2);
		list.add(head1);
		list.add(head2);
		LinkedListOperation ope=new LinkedListOperation();
		ListNode result=ope.mergeKLists(list);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}*/
		int i=1;
		while(i++ <10){
			System.out.println("test:"+i);
		}
		
	}
}
/**
 * TreeSet的比较器
 * @author luyna
 * 2015年1月30日
 */
class ListNodeComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		ListNode node1=(ListNode) arg0;
		ListNode node2=(ListNode) arg1;
		if(node1.val>node2.val) return 1;
		else if(node1.val<node2.val) return -1;
		else return 0;
	}
	
}