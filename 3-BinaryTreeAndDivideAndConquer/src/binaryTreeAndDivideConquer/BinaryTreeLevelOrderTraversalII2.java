package binaryTreeAndDivideConquer;

import java.util.ArrayList;

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
//version2: recursive //??? don't recommend
public class BinaryTreeLevelOrderTraversalII2 {
	public ArrayList<ArrayList<Integer>> ordertraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		traversal(root, result, 0);
		return result;
		
	}
	
	public void traversal(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
		if (root == null){
			return;
		}
		if (level >= result.size()){
			result.add(0, new ArrayList<Integer>());// why???
		}
		traversal(root.left, result, level + 1);
		traversal(root.right, result, level + 1);
		result.get(result.size() - level - 1).add(root.value); //put the root to the result set
	}//???

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
