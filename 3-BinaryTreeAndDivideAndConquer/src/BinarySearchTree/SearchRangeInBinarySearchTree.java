/*Search Range in Binary Search Tree
question: http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
answer:http://www.jiuzhang.com/solutions/search-range-in-binary-search-tree/

Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary
Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x 
such that k1<=x<=k2 and x is a key of given BST. Return all the keys in 
ascending order.

Example
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
*/

package BinarySearchTree;

import java.util.ArrayList;

import binaryTreeAndDivideConquer.TreeNode;

public class SearchRangeInBinarySearchTree {
	public static ArrayList<Integer> searchRangeinBST(TreeNode root, int k1, int k2){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null){
			return result;
		}
		searchRangeHelper(root, k1, k2, result);
		return result;
	}
	
	public static void searchRangeHelper(TreeNode root, int min, int max, ArrayList<Integer> list){
		if (root == null){
			return;
		}
		
		if (root.value > max || root.value < min){
			return;
		}
		
		if (min < root.value){
			searchRangeHelper(root.left, min, max, list);
		}
		if (root.value <= max && root.value >= min){
			list.add(root.value);
		}
		if (max > root.value){
			searchRangeHelper(root.right, min, max, list);
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Example
		If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

		    20
		   /  \
		  8   22
		 / \
		4   12
		*/
		
		TreeNode r1 = new TreeNode(20);
		TreeNode r2 = new TreeNode(8);
		TreeNode r3 = new TreeNode(22);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(12);
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
		
		
		TreeNode a1 = new TreeNode(2);
		TreeNode a2 = new TreeNode(1);
		a1.left = a2;
		a1.right = null;
		a2.left = null;
		a2.right = null;
		int m1 = 0;
		int m2 = 4;
		int k1 = 10;
		int k2 =22;
		System.out.println(searchRangeinBST(a1, m1, m2));
	}

}
