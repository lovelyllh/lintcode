/*Convert Sorted List to Binary Search Tree
question: http://www.lintcode.com/en/problem/convert-sorted-list-to-binary-search-tree/
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
               2
1->2->3  =>   / \
             1   3

*/
package FastSlowPointers;
import useDummyNodes.ListNode;
import binaryTreeAndDivideConquer.TreeNode;

//version3: use the middle element of the sorted list

public class ConvertLinkedListToBST2 {
	
    
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
    	if (head == null){
    		return null;
    	}
    	if (head.next == null){
    		TreeNode root = new TreeNode(head.val);
    		return root;
    	}
    	ListNode slow = head;
    	ListNode fast = head;//not head.next incase fast is not the last element
    	ListNode pre = head;
    	//find the middle element of the sorted list
    	//after the loop, slow will point to  the middle, fast will point to the end
    	while (fast != null && fast.next != null){
    		//record the element before the slow
    		pre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    		
    		
    	}
    	pre.next = null;
    	TreeNode root = new TreeNode(slow.val);
    	TreeNode left  = sortedListToBST(head);
    	TreeNode right = sortedListToBST(slow.next);	
    	root.left = left;
    	root.right = right;
		return root;
    }


	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConvertLinkedListToBST2 test = new ConvertLinkedListToBST2();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		System.out.println(test.sortedListToBST(n1).value);
	}

}
