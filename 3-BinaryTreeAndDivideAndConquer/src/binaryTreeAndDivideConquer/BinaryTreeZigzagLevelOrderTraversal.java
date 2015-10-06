/*Binary Tree Zigzag Level Order Traversal
question: http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/
answer:  http://www.jiuzhang.com/solutions/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
*/
package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static ArrayList<ArrayList<Integer>> zigzagLevelTraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		boolean normalorder = true;
		while (!queue.isEmpty()){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			normalorder = !normalorder;
			for (int i = 0; i < size; i++){
				TreeNode current = queue.poll();
				if (normalorder) {
					list.add(0, current.value);
				}else{
					list.add(current.value);
				}
				if (current.left != null){
					queue.offer(current.left);
					//TreeNode temp = current.left;
					//queue.offer(temp);
				}
				if (current.right != null){
					queue.offer(current.right);
					//TreeNode temp = current.right;
					//queue.offer(temp);
				}
			}
			result.add(list);
		}
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*3
		   / \
		  9  20
		    /  \
		   15   7*/
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
		System.out.println(zigzagLevelTraversal(r1));
	}

}
