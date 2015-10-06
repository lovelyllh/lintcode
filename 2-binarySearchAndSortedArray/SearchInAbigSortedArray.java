/*Search in a Big Sorted Array
Given a big sorted array, find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.

Example
Given [1, 3, 6, 9, 21], and target = 3, return 1.

Given [1, 3, 6, 9, 21], and target = 4, return -1.

Challenge
O(log k), k is the first index of the given target number.
*/
package binarySearchAndSortedArray;

public class SearchInAbigSortedArray {
	
	public static int search(int[] nums, int target){
		if (nums == null && nums.length == 0){
			return -1;
		}
		//O(logk)
		int end = 0;
		if (end < nums.length - 1 && nums[end] < target){
			end = end * 2 + 1;
		}
		//find the first index
		int start = 0;
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			if (nums[mid] < target){
				start = mid;
			}
			if (nums[mid] >= target){
				end = mid;
			}	
		}
		if (nums[start] == target){
			return start;
		}else if (nums[end] == target){
			return end;
		}else{
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 3, 6, 9, 21};
		int target = 3;
		int target1 = 4;
		System.out.println(search(nums, target));
		System.out.println(search(nums, target1));
	}

}
