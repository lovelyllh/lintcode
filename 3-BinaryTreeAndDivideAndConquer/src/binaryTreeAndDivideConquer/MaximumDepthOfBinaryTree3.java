/*Maximum Depth of Binary Tree
question: http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
answer: http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.
*/
//version3: iteration2: use queue *(recommended!)
/*题解 - 迭代(队列)

在使用了递归/后序遍历求解树最大深度之后，我们还可以直接从问题出发进行分析，树的最大深度即为广度优先搜索中的层数，
故可以直接使用广度优先搜索求出最大深度，在原结果返回处使用++max_depth替代即可。
*/
package binaryTreeAndDivideConquer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree3 {
	public static int maxDepth(TreeNode root){
		if (root == null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int maxlevel = 0;
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode current = queue.poll();
				if (current.left != null){
					queue.offer(current.left);
				}
				if (current.right != null){
					queue.offer(current.right);
				}
			}
			maxlevel++;
		}
		return maxlevel;
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
		System.out.println(maxDepth(r1));
	}
}
