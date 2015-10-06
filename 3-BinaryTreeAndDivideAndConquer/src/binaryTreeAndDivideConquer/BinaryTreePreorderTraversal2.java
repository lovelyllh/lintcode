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

//version 2: Traverse

public class BinaryTreePreorderTraversal2 {
	public static ArrayList<Integer> preOrderTraverse(TreeNode root){
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		//null or leaf
		if (root == null){
			return preorder;
		}
		preorderTraverse(root, preorder);
		return preorder;	
	}
	// 把root为跟的preorder加入result里面
	public static void preorderTraverse(TreeNode root, ArrayList<Integer> result){
		if (root == null){
			return;
		}
		result.add(root.value);
		preorderTraverse(root.left, result);
		preorderTraverse(root.right, result);
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
		System.out.println(preOrderTraverse(r1));

	}

}
