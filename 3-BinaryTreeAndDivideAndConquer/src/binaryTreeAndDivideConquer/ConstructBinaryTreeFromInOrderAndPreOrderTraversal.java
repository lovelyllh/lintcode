/*Construct Binary Tree from Preorder and Inorder Traversal
question: http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
answer:  http://www.jiuzhang.com/solutions/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.

Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.*/

package binaryTreeAndDivideConquer;

public class ConstructBinaryTreeFromInOrderAndPreOrderTraversal {
	public TreeNode buildTree(int[] inorder, int[] preorder){
		if (inorder.length != preorder.length){
			return null;
		}
		if (inorder == null || preorder == null){
			return null;
		}
		if (inorder.length == 0 || preorder.length == 0){
			return null;
		}
		return treeNodeHelper(inorder, 0 , inorder.length - 1,  preorder, 0, preorder.length - 1);
	}
	
	public TreeNode treeNodeHelper(int[]inorder, int instart, int inend, int[] preorder, int prestart, int preend){
		//corner case(base case)
		if (instart > inend || prestart > preend){
			return null;
		}
		//build root TreeNode
		int root_value = preorder[instart];
		TreeNode root = new TreeNode(root_value);
		//find index of root_val in inorder
		int index = findIndex(inorder, instart, inend , root_value);
		//build left subtree
		TreeNode left = treeNodeHelper(inorder, instart, index - 1, preorder, prestart + 1, prestart - instart + index);
		//build right suttree
		TreeNode right = treeNodeHelper(inorder, index + 1, inend, preorder,  prestart - instart + index + 1, preend);	
		/*preorder:
			|root|  .... left subtree .| ..... right subtree...|
		  inorder:
			|...left subtree ...| root | .... right subtree ...|*/
		return root;	
	}
	//bug 1: this is not a binary search tree, so we can't use binary search
	public int findIndex(int[] array, int start, int end, int key){
		for (int i = start; i <= end; i++){
			if (array[i] == key){
				return i;
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
