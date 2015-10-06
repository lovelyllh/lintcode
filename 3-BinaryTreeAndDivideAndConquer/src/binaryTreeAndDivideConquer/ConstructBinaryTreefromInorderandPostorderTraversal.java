/*Construct Binary Tree from Inorder and Postorder Traversal
question: http://www.lintcode.com/en/problem/construct-binary-tree-from-inorder-and-postorder-traversal/
answer: http://www.jiuzhang.com/solutions/construct-binary-tree-from-inorder-and-postorder-traversal/

Given inorder and postorder traversal of a tree, construct the binary tree.

Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.
*/
package binaryTreeAndDivideConquer;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static TreeNode buildTree(int[] inorder, int[] postorder){
		if (inorder == null || postorder == null){
			return null;
		}
		if (inorder.length == 0 || postorder.length == 0){
			return null;
		}
		if (inorder.length != postorder.length){
			return null;
		}
		
		return treeNodeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
		
	}
	
	public static TreeNode treeNodeHelper(int[] inorder, int instart, int inend, int[]postorder, int poststart, int postend){
		if (instart > inend || poststart > postend){
			return null;
		}
		//find root value in postorder
		int root_val = postorder[postend];
		//create the root node
		TreeNode root = new TreeNode(root_val);
		//find root index in inorder
		int index = findIndex(inorder, instart, inend, root_val);
		//left
		root.left = treeNodeHelper(inorder, instart, index - 1, postorder, poststart, poststart + index - instart - 1);//why?
		root.right = treeNodeHelper(inorder, index + 1, inend, postorder, poststart + index - instart, postend - 1);
		//postend -1 because bostend is root
		return root;
	}
	
	public static int findIndex(int[] nums, int start, int end, int key){
		int i;
		for (i = start; i <= end; i++){ //bug 1: i <= end, not i < end
			if (nums[i] == key){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
