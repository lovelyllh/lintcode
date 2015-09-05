package binarySearchAndSortedArray;

/*Search in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Example
For [4, 5, 1, 2, 3] and target=1, return 2.
For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge
O(logN) time
*/

public class SearchInRoatedSortedArray {
	public static int search(int[] nums, int target){
		//corner check
		if (nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (nums[mid] == target){
				return mid;//there's no duplicate
			}
			if (nums[start] <= nums[mid]){ //rotate left : ex, {3,4,5,6,7,1,2}
				if (nums[start] <= target && target <= nums[mid]){
					//nums[start] <= target && target <= nums[mid], search the left part
					end = mid;
				}else{
					start = mid;
				}
				
			}
			if (nums[start] > nums[mid]){ //rotate right: ex,{6,7,1,2,3,4,5}
				if (nums[mid] <= target && target <= nums[end]){
					//target > nums[mid] && target <= nums[end] search the right part
					start = mid;
				}else{
					end = mid;
				}			
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
		int[] nums = {1,2,3,4,5,9};
		int target = 9;
		System.out.println(search(nums, target));
	}
}
