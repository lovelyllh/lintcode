package binarySearchAndSortedArray;

/*Remove Duplicates from Sorted Array II
 * question: http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array-ii/
 * answer:  http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-array-ii/

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/
public class RemoveDuplicateFromSortedArrayII {
	public static int removeDuplicate(int[] nums){
		if (nums == null || nums.length == 0){
			return 0;
		}
		if (nums.length < 3){
			return nums.length;
		}
		int index = 1;
		int i;
		int j;
		for (i = 2; i < nums.length; i++){
			if (nums[i] == nums[index - 1]){ //if nums[index - 1] == nums[index] == nums[i], there are three duplicates
				continue;
			}
			//when there only two duplicates,
			index++;
			nums[index] = nums[i];
		}		
		return index + 1;	//add the case when index == 0
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicate(A));
	}

}
