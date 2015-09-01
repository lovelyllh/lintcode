package exhaustiveSearch;
import java.util.ArrayList;
import java.util.Collections;

/*Question:
 http://bulo.hujiang.com/menu/109531/list

 Given a list of numbers with duplicate number in it. Find all unique permutations.
 Medium Permutations II

 Given a list of numbers with duplicate number in it. Find all unique permutations.

 Have you met this question in a real interview? Yes
 Example
 For numbers [1,2,2] the unique permutations are:

 [

 [1,2,2],

 [2,1,2],

 [2,2,1]

 ]

 Challenge
 Do it without recursion.
 Answer:

 http://www.jiuzhang.com/solutions/permutations-ii/

 */

public class PermutaionsII {

	public static ArrayList<ArrayList<Integer>> PermuteUinqueList(
			ArrayList<Integer> nums) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null) {
			return result;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		// For deal with the duplicate solution, we should sort it.
		Collections.sort(nums);

		int[] visited = new int[nums.size()];

		permuteUniqueHelper(result, list, nums, visited);
		return result;

	}

	public static void permuteUniqueHelper(
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
			ArrayList<Integer> nums, int[] visited) {

		if (list.size() == nums.size()) {
			result.add(new ArrayList<Integer>(list));
			return; // use return keywords to get out of the current method.
		}

		for (int i = 0; i < nums.size(); i++) {
			// ȥ�ص����������� һ�����ڼ�������ʱ����contains�жϣ�һ�������ҽ����ʱ�����ǲ��Ǹ�ǰһ��Ԫ����ͬ��
			System.out.println("1. nums[ " + i + "]'s visited[i] is: "
					+ visited[i]);

			if (visited[i] == 1
					|| (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)) {
				// // important: if previous number have same value as (i)th
				// but have never been visited, then skip current number
				continue;
			}
			visited[i] = 1;
			list.add(nums.get(i));
			System.out.println("current list is:" + list);
			System.out.println("----------------------------");

			permuteUniqueHelper(result, list, nums, visited);

			list.remove(list.size() - 1);
			System.out.println("2. list after list.remove(list.size()-1)): "
					+ list);

			visited[i] = 0;
			System.out.println("3. nums[ " + i + "]'s visited[i] is: "
					+ visited[i]);
			System.out.println("4. current list is: " + list);

			System.out.println("----------------------------");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> source = new ArrayList<>();

		source.add(1);
		source.add(2);
		source.add(2);
		System.out.println("the final result is: " + PermuteUinqueList(source));

	}

}
