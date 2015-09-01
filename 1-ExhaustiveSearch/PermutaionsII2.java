package exhaustiveSearch;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutaionsII2 {

	public static ArrayList<ArrayList<Integer>> permuteUnique2list(int[] nums) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);

		boolean[] visited = new boolean[nums.length];

		// the default value for a boolean (primitive) is false.
		permuteUnique2Helper(result, list, nums, visited);

		return result;

	}

	public static void permuteUnique2Helper(
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
			int[] nums, boolean[] visited) {

		if (list.size() == nums.length) {

			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]
					|| (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
				// visited[i]: if nums[i] was visited already, skip
				// i>0 && nums[i]==nums[i-1] && !visited[i-1]):
				continue;
			}

			list.add(nums[i]);
			visited[i] = true;
			permuteUnique2Helper(result, list, nums, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] source = { 1, 2, 2 };
		System.out
				.println("the final result is: " + permuteUnique2list(source));

	}

}
