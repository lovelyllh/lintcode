package binaryTreeAndDivideConquer;

import java.util.ArrayList;

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


//version 2: traverse
public class BinaryTreePostorderTraversal2 {
	public static ArrayList<Integer> postTraversal(TreeNode root){
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		if (root == null){
			return postorder;
		}
		postorderTraverse(root, postorder);
		return postorder;
	}
	
	public static void postorderTraverse(TreeNode root, ArrayList<Integer> result){
		if (root == null){
			return;
		}	
		postorderTraverse(root.left, result);
		postorderTraverse(root.right,result);
		result.add(root.value);
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
		System.out.println(postTraversal(r1));

	}

}
