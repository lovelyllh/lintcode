package binarySearchAndSortedArray;
/*Search in Rotated Sorted Array II
question: http://www.lintcode.com/en/problem/search-in-rotated-sorted-array-ii/
answer: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array-ii/
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/

public class SearchInRoatedSortedArrayII2 {
	public static boolean search(int[] nums, int target){
		if (nums == null || nums.length == 0){
			return false;
		}
		for (int i = 0; i < nums.length; i++){
			if (nums[i] == target){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,4,5,1,2,3};
		int target = 8;
		System.out.println(search(A, target));
	}

}
