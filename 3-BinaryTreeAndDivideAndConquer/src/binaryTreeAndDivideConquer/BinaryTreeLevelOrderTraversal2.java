package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
//version2: recursive, why??? not recommend
public class BinaryTreeLevelOrderTraversal2 {
	public static ArrayList<ArrayList<Integer>> levelorder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		dfs(root, 0, result);
		return result;
		
	}
	
	public static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> result){
		if (root == null){
			return;
		}// 添加一个新的ArrayList表示新的一层  
		if (level >= result.size()){
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(root.value);  // 把节点添加到表示那一层的ArrayList里  
		dfs(root.left, level + 1, result);// 递归处理下一层的左子树和右子树  
		dfs(root.right, level + 1, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(levelorder(r1));

	}

}
