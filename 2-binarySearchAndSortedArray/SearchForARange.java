package binarySearchAndSortedArray;

import java.util.ArrayList;

/*Search for a Range
Given a sorted array of n integers, find the starting and ending position of a given target value.
If the target is not found in the array, return [-1, -1].
Example
Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
Challenge
O(log n) time.
*/
public class SearchForARange {
	public static ArrayList<Integer> searchRange(ArrayList<Integer> nums, int target){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(-1);
		result.add(-1);
		if (nums == null){
			return result;
		}
		int start;
		int end;
		int mid;
		//search for left bound
		start = 0;
		end = nums.size() - 1;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (nums.get(mid) == target){
				end = mid;
			}else if (nums.get(mid) < target){
				start = mid;
			}else{
				end = mid;
			}		
		}	
		if (nums.get(start) == target){//in the left bound, first check the start point
			result.set(0, start);
		}else if (nums.get(end) == target){
			result.set(0, end);	
		}else{
			return result;
		}		
		
		//search for the right bound
		start = 0; //rememeber to re-set the start and end value
		end = nums.size() - 1;
		while (start + 1 < end){
			mid = start + (end - start ) / 2;
			if (nums.get(mid) == target){
				start = mid;
			}else if (nums.get(mid) < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (nums.get(end) == target){ //in the right bound, first check the end point
			result.set(1,end);
		}else if (nums.get(end) ==start){
			result.set(1, start);
		}else{
			return result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);
		nums.add(5);

		int target = 5;
		System.out.println(searchRange(nums, target));

	}
}
