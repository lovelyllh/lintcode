package binarySearchAndSortedArray;
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
