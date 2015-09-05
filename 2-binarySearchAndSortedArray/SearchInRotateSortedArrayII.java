package binarySearchAndSortedArray;

/*Search in Rotated Sorted Array II
question: http://www.lintcode.com/en/problem/search-in-rotated-sorted-array-ii/
answer: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array-ii/
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.

time complexity: O(n)
*/
public class SearchInRotateSortedArrayII {
	public static boolean search(int[] nums, int target){
		if (nums == null || nums.length == 0){
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (nums[mid] == target){
				return true;
			}
			if (nums[start] < nums[mid]){ //rotate left : ex, {3,4,4,6,7,1,2} // 
				//part 1: situation 1, numbers between start and mid are sorted
				if (nums[start] < target && target <= nums[mid]){
					end = mid;
				}else{
					start = mid;
				}
			}else if(nums[start] > nums[mid]){ //rotate right: ex,{6,7,1,2,3,4,4}  
				//part 2 // situation 2, numbers between mid and target are sorted
				if (nums[mid] < target && target <= nums[end]){
					start = mid;
				}else{
					return true;
				}
			}else{
				++start;
			}
		}
		if (nums[start] == target){
			return true;
		}else if (nums[end] == target){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,4,5,1,2,3};
		int target = 4;
		System.out.println(search(A, target));

	}

}
