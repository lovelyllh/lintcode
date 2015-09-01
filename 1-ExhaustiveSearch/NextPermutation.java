package exhaustiveSearch;

/*
 question:  Next Permutation
 Given a list of integers, which denote a permutation.Find the next permutation in ascending order.
 Example
 For [1,3,2,3], the next permutation is [1,3,3,2]
 For [4,3,2,1], the next permutation is [1,2,3,4]

 Note
 The list may contains duplicate integers.
 *
 *解答：
 1. 从尾部往前搜索，先找到第一个下降的数字，标记之。
 例子： 12431， 则我们找到的是 2
 2. 还是从尾往前搜索，找到第一个比2大的数字 ，交换之。
 12431 --> 13421
 3. 将421进行反序。这样我们可以得到一个高位增加后的最小的后续值
 13421 --> 13124
 *
 */

public class NextPermutation {

	public static void nextPermutationNoDup(int[] nums) {

		if (nums == null) {
			return;
		}
		// 从尾部往前搜索，先找到第一个下降的数字，标记之。
		// 例子： 12431， 则我们找到的是 2
		int index = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > nums[i]) {
				index = i;
				break;
			}
		}
		// case 1 : e.g: {5,4,3,2,1} -> {1,2,3,4,5}
		if (index == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		// case 2: Find the first digital which is bigger than the digital just
		// found.
		int biggerIndex = index + 1;
		for (int j = nums.length - 1; j > index; j--) {
			if (nums[j] > nums[index]) {
				biggerIndex = j;
				break;
			}
		}
		swap(nums, index, biggerIndex);
		// reverse the last part from index+1 to n
		reverse(nums, index + 1, nums.length - 1);
	}

	// reverse the array
	public static void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}

	// swap the i, j element in the array.
	public static void swap(int[] nums, int i, int j) {
		int temp;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] source = { 1, 3, 2 };
		NextPermutation.nextPermutationNoDup(source);
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]);
		}
	}
}
