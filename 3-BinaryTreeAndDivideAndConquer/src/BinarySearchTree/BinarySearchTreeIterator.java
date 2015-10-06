/*Binary Search Tree Iterator
question: http://www.lintcode.com/en/problem/binary-search-tree-iterator/
answer:  http://www.jiuzhang.com/solutions/implement-iterator-of-binary-search-tree/

Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.

Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge
Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)
*/

package BinarySearchTree;

import java.util.Stack;

import binaryTreeAndDivideConquer.TreeNode;

public class BinarySearchTreeIterator {
	private Stack<TreeNode> st = new Stack<TreeNode>();//remember to new a stack
	private TreeNode current;
	
	public BinarySearchTreeIterator(TreeNode root){
		this.current = root;
	}
	
	public boolean hasNext(){
		return (current != null || !st.empty());
		
	}
	
	public TreeNode next(){
		while (current != null){
			st.push(current);
			current = current.left;
		}
		TreeNode current = st.peek();
		st.pop();
		TreeNode node = current;
		current = current.right;
		return node;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*10
		 /    \
		1      11
		 \       \
		  6       12*/
		TreeNode r1 = new TreeNode(10);
		TreeNode r2 = new TreeNode(1);
		TreeNode r3 = new TreeNode(11);
		TreeNode r4 = new TreeNode(6);
		TreeNode r5 = new TreeNode(12);
		
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = r4;
		r3.left = null;
		r3.right = r5;
		r4.left = null;
		r4.right = null;
		r5.left = null;
		r5.right = null;
		BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(r1);
		boolean a = iterator.hasNext();
		TreeNode b = iterator.next();
		System.out.println(a);
		System.out.println(b.value);
		
		

	}

}
