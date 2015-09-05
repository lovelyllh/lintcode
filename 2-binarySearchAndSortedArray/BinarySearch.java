package binarySearchAndSortedArray;

/*Binary Search
question: http://www.lintcode.com/en/problem/binary-search/
Answer:  http://www.jiuzhang.com//solutions/binary-search/

For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time 
complexity. If the target number does not exist in the array, return -1.
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
Challenge
If the count of numbers is bigger than 2^32, can your code work properly?

time complexity: o(lgn)
*/

public class BinarySearch {
	public static int BinarySearch(int[] num, int target){
		//corner check
		if(num == null || num.length == 0){
			return -1;
		}
		int start = 0;
		int end = num.length - 1;
		while(start + 1 < end){ //use iteration below; if start == end, there will be a dead loop
			int mid = start + (end - start) / 2;//prevent overflow when two integers added
			if (target < num[mid]){
				end = mid;
			}else if(target == num[mid]){
				end = mid; //prevent duplicate
			}else{
				start = mid;
			}
		}
		if (num[start] == target){
			return start;
		}
		if (num[end] == target){
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,3,4,5,10};
		int target = 3;
		System.out.println(BinarySearch(nums, 3));
	}
}
