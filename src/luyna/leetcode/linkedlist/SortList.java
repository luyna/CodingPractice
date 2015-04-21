package luyna.leetcode.linkedlist;
/**
 * 将LinkedList排序，要求时间复杂度O(nlgn)，空间复杂度：O(1)
 * 思路：
 *如果链表结构可以改变，可以遍历一遍链表，将单链表改成双向链表，然后采用快速排序的思想排序，最后去掉链表的反向链
 * 
 * @author luyna
 * 2015年3月7日
 */
public class SortList {
	 public ListNode sortList(ListNode head) {
		 if(head==null || head.next==null) return head;
	      while(head.next!=null) {
	    	  ListNode tmp=head.next;
	    	  
	      }
	 }
}
