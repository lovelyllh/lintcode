/*Binary Tree Serialization
question: http://www.lintcode.com/en/problem/binary-tree-serialization/
answer: http://www.jiuzhang.com/problem/51/
https://github.com/billryan/algorithm-exercise/blob/master/zh-cn/binary_tree/binary_tree_serialization.md

Design an algorithm and write code to serialize and deserialize a binary tree. 
Writing the tree to a file is called 'serialization' and reading back from the file to 
reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make 
sure you can serialize a binary tree to a string and deserialize this string to the 
original structure.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
*/

package binaryTreeAndDivideConquer;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
	//serialiazation
	//BFS
	public static String serialization(TreeNode root){
		StringBuffer str = new StringBuffer();
		//bug1: notice toString()
		if  (root == null){
			return str.toString();
		}
		str.append(root.value);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode current = queue.poll();
				if (current.left != null){
					queue.offer(current.left);
					str.append(current.left.value);
				}else{
					str.append('#');
				}
				if (current.right != null){
					queue.offer(current.right);
					str.append(current.right.value);
				}else{
					str.append('#');
				}
				
			}
		}
		//delete the trailing # after the last leaf
		int i = str.length() - 1;
		while (i >= 0 && str.charAt(i) == '#'){
			str.deleteCharAt(i);
			i--;
		}
		
		return str.toString();		
	}
	//deserialization
	public static TreeNode deserialization(String data){
		if (data == null && data.isEmpty()){
			return null;
		}
		String[] str = data.split(",");
		
		//get root value
		int root_val = Integer.parseInt(str[0]);
		TreeNode root = new TreeNode(root_val);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		//construct left tree and right tree
		for (int i = 1; i < str.length; i++){
			TreeNode left = null;
			TreeNode right = null;
			//bug1: not str[i] != '#'
			if (!str[i].equals("#") ){
				left = new TreeNode(Integer.parseInt(str[i]));
			}
			//bug2: ++i, not i++
			if (++i < str.length && !str[i].equals("#")){
				right = new TreeNode(Integer.parseInt(str[i]));
			}
			//define parent-child relationship
			TreeNode parent = queue.poll();
			parent.left = left;
			parent.right = right;
			if (left != null){
				queue.offer(left);
			}
			if (right != null){
				queue.offer(right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*{3,9,20,#,#,15,7}*/
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
		
		String data = "3,9,20,#,#,15,7";
		System.out.println(serialization(r1));
		System.out.println(deserialization(data).value);
	}

}
