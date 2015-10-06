package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;

/*Binary Tree Level Order Traversal
Question: http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
Answer: http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge
Using only 1 queue to implement it.
*/
//version 1:iteration //recommend, don't need the recursive version

/*Analysis

For this problem, we need to remember solidly the template for BFS, we should keep in mind below things:

1. Define one queue using linkedList, and offer the root into the queue, so it 
	has only one element, we can do something as long as the queue is not empty
2. We can expand the queue by maintaining the previous size, so the first size
 	is queue.size()
3. Here we define an ArrayList level to express our sub result in every level, we cannot define the ArrayList outside of the loop
4. For every level, we pick up one from left, poll the element out and add to the level result, at the same time we check and add its left or right child into the queue, so every level processing we are expecting the queue has a larger size!
5. After every level traversal, we add the level result ArrayList in to the final ArrayList of ArrayList
*/
public class BinaryTreeLevelOrderTraversal {
	public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}			
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();	
		queue.offer(root); 
		while (!queue.isEmpty()){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int size = queue.size();//·Ö²ã
			for (int i = 0; i < size; i++){			
				TreeNode current = queue.poll(); //step1: use queue to withhold parent
				list.add(current.value);//poll one parent, and add the parent's value to list
				//step2: add children to queue, jump to next level
				if (current.left != null){
					queue.offer(current.left);
				}
				if (current.right != null){
					queue.offer(current.right);
				}	
			}
			result.add(list);
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
		System.out.println(levelOrderTraversal(r1));
	}
}
