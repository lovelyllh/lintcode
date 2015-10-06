package binaryTreeAndDivideConquer;

import java.util.ArrayList;

/*Binary Tree Preorder Traversal
question: http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
answer:  http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/

Given a binary tree, return the preorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3}:

1
\
 2
/
3
return [1,2,3].

Challenge
Can you do it without recursion?
*/
//don't recommend recursion

//version 3 recursive: divide and conquer
public class BinaryTreePreorderTraversal3 {
	public static ArrayList<Integer> preOrderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null){
			return result;
		}
		//divide
		ArrayList<Integer> left = preOrderTraversal(root.left);
		ArrayList<Integer> right = preOrderTraversal(root.right);
		//conquer
		result.add(root.value);
		result.addAll(left);
		result.addAll(right);
		return result;
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
		System.out.println(preOrderTraversal(r1));

	}

}
