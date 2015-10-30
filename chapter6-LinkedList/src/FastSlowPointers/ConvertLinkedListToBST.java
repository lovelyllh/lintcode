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

//version1: use global variable

public class ConvertLinkedListToBST {
	private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        current = head;
        int size = getlistsize(head);
        return listtobsthelper(size);
    }
    
    public int getlistsize(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    
    public TreeNode listtobsthelper(int size){
        if (size <= 0){
            return null;
        }
        
        //left tree is the left list
        TreeNode left = listtobsthelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        //only if there are three elements
        current = current.next;
        TreeNode right = listtobsthelper(size - 1 - size / 2);
        //link left tree and right tree to root
        root.left = left;
        root.right = right;
        return root;
    }

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConvertLinkedListToBST test = new ConvertLinkedListToBST();
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
