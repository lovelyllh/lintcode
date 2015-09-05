/*Merge Sorted Array II
Question: http://www.lintcode.com/en/problem/merge-sorted-array-ii/#

Merge two given sorted integer array A and B into a new sorted integer array.
Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?

Answer: http://www.jiuzhang.com/solutions/merge-sorted-array-ii/

*/



package binarySearchAndSortedArray;

import java.util.ArrayList;
import java.util.Collections;

public class MergeSortedArrayII {
	
	public static ArrayList<Integer> mergeSortedArrayII(ArrayList<Integer> A, ArrayList<Integer>B){
		int len = B.size();
		for (int i = 0; i < len; i++){
			A.add(B.get(i));
		}
		Collections.sort(A);	
		return A;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		B.add(2);
		B.add(4);
		B.add(5);
		B.add(6);
		System.out.println(mergeSortedArrayII(A,B));

	}

}
