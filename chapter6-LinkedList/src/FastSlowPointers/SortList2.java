/*Sort List
question: http://www.lintcode.com/en/problem/sort-list/

Sort a linked list in O(n log n) time using constant space complexity.

Have you met this question in a real interview? Yes
Example
Given 1-3->2->null, sort it to 1->2->3->null.
*/

package FastSlowPointers;

import useDummyNodes.ListNode;

//version2: quick sort
public class SortList2 {
	 //version2: quick sort
    public static ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null){
            return head;
        }
        //1. find middle
        ListNode middle = findmiddle(head);//pivot
        //2. quicksort
        //create three dummy nodes for left, middle, right lists
        ListNode leftdummy = new ListNode(0);
        ListNode middledummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode lefttail = leftdummy;
        ListNode middletail = middledummy;
        ListNode righttail = rightdummy;
        //quick sort: 1. partition
        while (head != null){
            if (head.val < middle.val){
                lefttail.next = head;
                lefttail = lefttail.next;
            }else if (head.val == middle.val){
                middletail.next = head;
                middletail = middletail.next;
            }else{
                righttail.next = head;
                righttail = righttail.next;
            }
            head = head.next;
        }
        //add null to the end of the three list
        lefttail.next = null;
        middletail.next = null;
        righttail.next = null;
        //3. split
        ListNode left = sortList(leftdummy.next);
        ListNode right = sortList(rightdummy.next);
        middle = middledummy.next;
        //4. merge
        return concat(left, middle, right);
    }
    
    public static ListNode findmiddle(ListNode head){
        //use fast and slow pointers
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
 
    public static ListNode concat(ListNode left, ListNode middle, ListNode right){
        //3. concatenate left,middle and right
        ListNode dummy = new ListNode(0), 
        tail = dummy;
        tail.next = left; 
        tail = getTail(tail);
        tail.next = middle; 
        tail = getTail(tail);
        tail.next = right; 
        tail = getTail(tail);
        return dummy.next;
    }
    
    public static ListNode getTail(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(sortList(n1).val);
	}
}
