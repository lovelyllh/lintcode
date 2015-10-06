package binaryTreeAndDivideConquer;

/*Minimum Depth of Binary Tree
question:
answer:
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Example
Given a binary tree as follow:

        1

     /     \ 

   2       3

          /    \

        4      5  

The minimum depth is 2
*/

public class MinimumDepthOfBinaryTree {
	public static int minDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        return getMinDepth(root);     
    }
	
	public static int getMinDepth(TreeNode root){
		if (root == null){ //若我们有这个判断句， 就不用再判断左字数或者右子树是否为空了。但是我们需要判断两个字数是否都为空
			return Integer.MAX_VALUE; //notice this return value should set to max,
		}
		if (root.left == null && root.right == null){
			return 1;
		}	
		int leftdepth = getMinDepth(root.left);
		int rightdepth = getMinDepth(root.right);
		return Math.min(leftdepth, rightdepth) + 1;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
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
		
		TreeNode a1= new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		a1.left = null;
		a1.right = a2;
		a2.left = a3;
		a2.right = null;
		a3.left = null;
		a3.right = null;
		System.out.println(minDepth(r1));
		System.out.println(minDepth(a1));
	}

}
