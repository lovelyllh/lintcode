/*Remove Node in Binary Search Tree
question: http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
answer:  http://www.jiuzhang.com/solutions/remove-node-in-binary-search-tree/

Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

Example
Given binary search tree:

          5

       /    \

    3          6

 /    \

2       4

Remove 3, you can either return:

          5

       /    \

    2          6

      \

         4

or :

          5

       /    \

    4          6

 /   

2*/
package BinarySearchTree;

import binaryTreeAndDivideConquer.TreeNode;

public class DeleteANodeInABST {
	public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null){
            return null;
        }//search for the deleted node
        if (value < root.value){
            root.left =  removeNode(root.left, value);
        }else if (value > root.value){
            root.right = removeNode(root.right, value);
        }else{
            //case 1: there's only one child of the deleted node
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            //find the succesor of the right sub-tree in in-order traversal
            //TreeNode succesor = getMin(root);
            TreeNode succesor = root.right;
            while (succesor.left != null){
                succesor = succesor.left;
            }
            //set the value to succesor's value
            root.value = succesor.value;
            //delete the succesor
            root.right = removeNode(root.right, succesor.value);
        }
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*   5

	       /    \

	    3          6

	 /    \

	2       4*/
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(6);
		TreeNode r4 = new TreeNode(2);
		TreeNode r5 = new TreeNode(4);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = null;
		r3.right = null;
		r4.left = null;
		r4.right = null;
		r5.left = null;
		r5.right = null;		
		System.out.println(removeNode(r1, r2.value).value);
	}
}
