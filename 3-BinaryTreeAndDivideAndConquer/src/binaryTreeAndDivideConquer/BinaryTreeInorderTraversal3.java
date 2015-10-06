package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.Stack;

/*Binary Tree Inorder Traversal
question: http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
answer: http://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].

Challenge
Can you do it without recursion?

使用辅助栈，空间复杂度 O(n), 时间复杂度 O(n).
*/
//version 3: iteration
/*中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内， 
* 然后输出栈顶元素，再处理栈顶元素的右子树 
* http://www.youtube.com/watch?v=50v1sJkjxoc 
*/public class BinaryTreeInorderTraversal3 {
	public static ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		if (root == null){
			return inorder;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode current = root;
		//while has next
		while (current != null || !st.empty()){
			while (current != null){//iteratively push all the non-empty left child into stack// 先添加一个非空节点所有的左孩子到栈
				st.push(current);
				current = current.left;
			}
			//when current pointer is null, pop the element from the stack
			//all the sequence in stack pop up from bottom until encounter one child
			current = st.peek();	
			inorder.add(current.value);
			st.pop();//don't forget to pop from stack after add it to arraylist
			current = current.right;//prepare to do the right child	
		}
		return inorder;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		r1.left = null;
		r1.right = r2;
		r2.left = r3;
		r2.right = null;
		r3.left = null;
		r3.right = null;
		System.out.println(inorderTraversal(r1));

	}

}
