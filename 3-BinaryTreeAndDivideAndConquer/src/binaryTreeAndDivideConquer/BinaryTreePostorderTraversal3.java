package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.Stack;

/*Binary Tree Postorder Traversal
question: http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
answer: http://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/

Given a binary tree, return the postorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 
return [3,2,1].

Challenge
Can you do it without recursion?
*/


//version 3: iteration + reverse: two stacks
public class BinaryTreePostorderTraversal3 {
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
	        //version 5:iteration£º use two stacks, recommend!!
	        ArrayList<Integer> postorder = new ArrayList<Integer>();
	        if (root == null){
	            return postorder;
	        }
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        Stack<TreeNode> output = new Stack<TreeNode>();
	        TreeNode current;
	        st.push(root);
	        while (!st.empty()){
	            current = st.pop();
	            output.push(current);
	            if (current.left != null){
	                st.push(current.left);
	            }
	            if (current.right != null){
	                st.push(current.right);
	            }
	        } //the above procedure is a pre-order traversal
	        while (!output.empty()){
	            postorder.add(output.pop().value);//reverse
	        }
	        return postorder;
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
		System.out.println(postorderTraversal(r1));

	}

}
