/*Validate Binary Search Tree
question: http://www.lintcode.com/en/problem/validate-binary-search-tree/
answer:  http://www.jiuzhang.com/solutions/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example
An example:

  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
*/

//version2: traverse
//time complexity:O(n)
//space complexity: O(c)

package BinarySearchTree;

import java.util.ArrayList;

import binaryTreeAndDivideConquer.TreeNode;

public class ValidateBinarySearchTree2{
	public static boolean isValidBST(TreeNode root){
		if (root == null){
			return true;
		}
		ArrayList<Integer> result = inordertraverse(root);
		for (int i = 1; i < result.size(); i++){
			if (result.get(i) <= result.get(i-1)){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> inordertraverse(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null){
			return list;
		}
		list.addAll(inordertraverse(root.left));
		list.add(root.value);
		list.addAll(inordertraverse(root.right));
		return list;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(10);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(15);
		TreeNode r4 = new TreeNode(6);
		TreeNode r5 = new TreeNode(20);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = r4;
		r3.right = r5;
		System.out.println(isValidBST(r1));
	}
}
