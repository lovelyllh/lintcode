/*Previous Permutation
 * 1.Given a list of integers, which denote a permutation. Find the 
 * previous permutation in ascending order.
 * 
 * Example
For [1,3,2,3], the previous permutation is [1,2,3,3]
For [1,2,3,4], the previous permutation is [4,3,2,1]

Challenge
The list may contains duplicate integers.
 * 
 * 2.  Answer:
 * 
 * 
 * */



package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Collections;


public class PreviousPermutation {
	
	public static ArrayList<Integer> previousPermutation(ArrayList<Integer> nums){
		if (nums == null){
			return nums;
		}
		
		//step 1: find the first decreasing index i
		int index = -1;
		for (int i = nums.size() - 2; i >= 0; i--){
			if (nums.get(i) > nums.get(i+1)){
				index = i;
				break;
			}
		}
		//step 2: case1: {1,2,3,4,5}
		if (index == -1){
			reverse(nums, 0, nums.size()-1);
			return nums;
		}
		//step2: case2: {1,3,2,4,5}, find the first smaller number
		int smallerIndex = index + 1;
		for (int i = nums.size() - 1; i < index; i--){
			if (nums.get(i) < nums.get(index)){
				smallerIndex = i;
				break;
			}
		}
		Collections.swap(nums, index, smallerIndex);
		reverse(nums, index + 1, nums.size() - 1);
		
		return nums;
		
	}
	
	public static void reverse(ArrayList<Integer> nums, int start, int end){
		int i;
		int j;
		for(i = start, j = end; i < j; i++, j--){
			Collections.swap(nums, i, j);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> source = new ArrayList<Integer>();
		source.add(1);
		source.add(3);
		source.add(2);
		source.add(3);
		System.out.println(previousPermutation(source));
	}

}
