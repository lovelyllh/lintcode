package binarySearchAndSortedArray;

/*remove Duplicates from Sorted Array
qustion: http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
answer:  http://www.jiuzhang.com/solutions/search/?question=Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

Example
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
*/

public class RemoveDuplicateFromSortedArray {
	public static int removeDupliate(int[] nums){
		if (nums == null || nums.length == 0){
			return 0;
		}
		int index = 0;// count the size of the unique number
		int i;
		for (i = 0; i < nums.length; i++){
			if (nums[i] == nums[index]){
				continue;
			}
			index++;
			nums[index] = nums[i]; //store the unique value  using index
		}
		return index + 1 ;	// add the case when index = 0
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2};
		System.out.println(removeDupliate(A));

	}

}
