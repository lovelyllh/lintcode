/*Recover Rotated Sorted Array
Question: http://www.lintcode.com/en/problem/recover-rotated-sorted-array/

Given a rotated sorted array, recover it to sorted array in-place.

example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
Challenge
In-place, O(1) extra space and O(n) time.

Clarification
What is rotated array?
For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

Answer:
http://www.jiuzhang.com/solutions/recover-rotated-sorted-array/

*/
package binarySearchAndSortedArray;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverRotatedSortedArray {
	
	public static void recoverRoatedSortedArray(ArrayList<Integer> num){
		//e.g: {4,5,1,2,3}, find the first descending index
		for (int i = 0; i < num.size() - 1; i++){
			if (num.get(i) > num.get(i+1)){
				reverse(num, 0, i);
				reverse(num, i+1, num.size()-1);
				reverse(num, 0, num.size()-1);
				break;
			}	
			
		}
		
	}
	
	public static void reverse(ArrayList<Integer>num, int start, int end){
		int i;
		int j;
		for (i = start, j = end; i < j; i++, j--){
			swap(num, i,j);
		}
	}
	
	public static void swap(ArrayList<Integer> num, int i, int j){
		int temp;
		temp = num.get(i);
		num.set(i, num.get(j));
		num.set(j, temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(4);
		num.add(5);
		num.add(1);
		num.add(2);
		num.add(3);
		recoverRoatedSortedArray(num);
		System.out.println(num);	
	}
}
