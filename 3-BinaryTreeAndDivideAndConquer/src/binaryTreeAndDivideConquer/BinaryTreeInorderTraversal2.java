package binaryTreeAndDivideConquer;

import java.util.ArrayList;

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
*/
//version 2: traverse
public class BinaryTreeInorderTraversal2 {
	public static ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		if (root == null){
			return inorder;
		}
		traverse(root, inorder);
		return inorder;	
	}
	
	public static void traverse(TreeNode root, ArrayList<Integer> list){
		if (root == null){
			return;
		}
		traverse(root.left, list);
		list.add(root.value);
		traverse(root.right,list);		
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
