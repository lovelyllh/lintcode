package exhaustiveSearch;

/*
 question:  Next Permutation
 http://www.lintcode.com/en/problem/next-permutation/#

 Given a list of integers, which denote a permutation.Find the next permutation in ascending order.

 Example
 For [1,3,2,3], the next permutation is [1,3,3,2]
 For [4,3,2,1], the next permutation is [1,2,3,4]

 Note
 The list may contains duplicate integers.

 *Anser:
 *http://www.jiuzhang.com/solutions/next-permutation/
 *
 *���
 1. ��β����ǰ���������ҵ���һ���½������֣����֮��
 ���ӣ� 12431�� �������ҵ����� 2
 2. ���Ǵ�β��ǰ�������ҵ���һ����2������� ������֮��
 12431 --> 13421
 3. ��421���з����������ǿ��Եõ�һ����λ���Ӻ����С�ĺ���ֵ
 13421 --> 13124
 *
 */

public class NextPermutation {

	public static void nextPermutationNoDup(int[] nums) {

		if (nums == null) {
			return;
		}
		// ��β����ǰ���������ҵ���һ���½������֣����֮��
		// ���ӣ� 12431�� �������ҵ����� 2
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
