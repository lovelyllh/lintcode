package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
*/
//version1: iteration: recommend!
public class BinaryTreeLevelOrderTraversalII {
	public static ArrayList<ArrayList<Integer>> leveloreder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode current = queue.poll();
				list.add(current.value);
				if (current.left != null){
					queue.offer(current.left);
				}
				if (current.right != null){
					queue.offer(current.right);
				}
			}
			result.add(0, list);//or use Collections.reverse(result);
		}	
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{3,9,20,#,#,15,7},
		 /* 3
		   / \
		  9  20
		    /  \
		   15   7
		   */
		TreeNode r1 = new TreeNode(3);
		TreeNode r2 = new TreeNode(9);
		TreeNode r3 = new TreeNode(20);
		TreeNode r4 = new TreeNode(15);
		TreeNode r5 = new TreeNode(7);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = r4;
		r3.right = r5;
		r4.left = null;
		r4.right = null;
		r5.left = null;
		r5.right = null;
		System.out.println(leveloreder(r1));
	}
}
