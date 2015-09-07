package binarySearchAndSortedArray;

import java.util.ArrayList;

/*Merge Sorted Array II
Question: http://www.lintcode.com/en/problem/merge-sorted-array-ii/#

Merge two given sorted integer array A and B into a new sorted integer array.
Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?

Answer: http://www.cnblogs.com/EdwardLiu/p/4340934.html

*/

public class MergeSortedArrayII2 {
	public static ArrayList<Integer> mergeArray(ArrayList<Integer> A, ArrayList<Integer> B){
		if (A == null || A.size() ==0){
			return B;
		}
		if (B ==null || B.size() == 0){
			return A;
		}
		if ((A == null || A.size() == 0) && (B == null || B.size() == 0)){
			return null;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex < A.size() && bIndex < B.size()){
			if (A.get(aIndex) < B.get(bIndex)){
				result.add(A.get(aIndex));
				aIndex++;
			}else{
				result.add(B.get(bIndex));
				bIndex++;
			}
		}
		while (aIndex < A.size()){
			result.add(A.get(aIndex));
			aIndex++;
		}
		while (bIndex < B.size()){
			result.add(B.get(bIndex));
			bIndex++;
		}
		return result;
		
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
		System.out.println(mergeArray(A,B));


	}

}
