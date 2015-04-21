package luyna.leetcode.linkedlist;


 /**
 * @author Luyna
 *
 * 2014年12月12日
 * Write a program to find the node at which the intersection of two singly linked lists begins.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 * There are many solutions to this problem:

1、Brute-force solution (O(mn) running time, O(1) memory):
For each node ai in list A, traverse the entire list B and
 check if any node in list B coincides with ai.

2、Hashset solution (O(n+m) running time, O(n) or O(m) memory):
Traverse list A and store the address / reference to each node in a hash set.
 Then check every node bi in list B: if bi appears in the hash set, then bi 
 is the intersection node.

3、Two pointer solution (O(n+m) running time, O(1) memory):
Maintain two pointers pA and pB initialized at the head of A and B, respectively. 
Then let them both traverse through the lists, one node at a time.
When pA reaches the end of a list, then redirect it to the head of B 
(yes, B, that's right.); similarly when pB reaches the end of a list, 
redirect it the head of A.
If at any point pA meets pB, then pA/pB is the intersection node.
To see why the above trick would work, consider the following two 
lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected 
at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end 
of the merged list first, because pB traverses exactly 2 nodes less than 
pA does. By redirecting pB to head A, and pA to head B, we now ask pB to 
travel exactly 2 more nodes than pA would. So in the second iteration, 
they are guaranteed to reach the intersection node at the same time.
If two lists have intersection, then their last nodes must be the same 
one. So when pA/pB reaches the end of a list, record the last element of
 A/B respectively. If the two last elements are not the same one, then the
  two lists have no intersections.
 * 4、考虑到两个链表如果有题目中描述的交集，那么从后往前的若干个节点是相同的，那么可以先将两链表右对齐，将长的链表
 * “截断”与短链表长度相同，依次遍历比较如果发现有两个节点的值相同，那么说明从该节点开始两链表开始出现交集。
 */
 

public class LinkedListIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null) return null;
		int lenA=listlen(headA);
		int lenB=listlen(headB);
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }

	    while(lenA<lenB){
			headB=headB.next;
			lenB--;
		}
		while(headA!=headB){
			headA=headA.next;
			headB=headB.next;
		}

		return headA;
    }
	
	public int listlen(ListNode head){
		int len=0;
		while(head!=null){
			len++;
			head=head.next;
		}
		return len;
	}
}
