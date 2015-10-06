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
//version2: DFS: recursive (preorder)

package binaryTreeAndDivideConquer;

import java.util.StringTokenizer;

public class BinaryTreeSerialization2 {
	//serialization
	public static String serialization(TreeNode root){
		if (root == null){
			return "#,";
		}
		String str = root.value + ",";
		String left = serialization(root.left);
		String right = serialization(root.right);
		str = str + left + right;
		return str;
	}
	public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
        	return null;
        }
        StringTokenizer st = new StringTokenizer(data, ",");
        return deserializationHelper(st);
    }

	public static TreeNode deserializationHelper(StringTokenizer st){
		if (st.hasMoreTokens()){
			return null;
		}
		String value = st.nextToken();
		if (value.equals("#")){	
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(value));
		root.left = deserializationHelper(st); //TreeNode root =  ?//?
		root.right = deserializationHelper(st);
		return root;
	}

	public static void main(String[] args) {
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
		System.out.println(deserialize(data));
	}

}
