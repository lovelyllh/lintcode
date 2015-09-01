package exhaustiveSearch;
import java.util.ArrayList;

/*quesion:
 * http://www.lintcode.com/en/problem/permutations/
 * answer:
 * http://www.jiuzhang.com/solutions/permutations/
 * http://algorithm.yuanbin.me/exhaustive_search/permutation.html
 * 
 * Given a list of numbers, return all possible permutations.
 * question: http://www.lintcode.com/en/problem/permutations/
 * 
 * Example
 * 
 For nums = [1,2,3], the permutations are:

 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 Challenge
 Do it without recursion.
 * 
 *  time complexity: o(n!*n)
 * */

public class Permutations {

	public static ArrayList<ArrayList<Integer>> PermutList(
			ArrayList<Integer> num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num == null) {
			return result;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		permutHelper(result, list, num);
		return result;
	}

	public static void permutHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, ArrayList<Integer> num) {

		if (list.size() == num.size()) { // 递归的基本条件，也是终止条件。
			result.add(new ArrayList<Integer>(list));
			System.out.println("1. current list is: " + list);
			System.out.println("1-1. the current result is: " + result);
			return;
		} // this block is important
		for (int i = 0; i < num.size(); i++) {
			System.out.println("3. the current list in for loop is: " + list);
			if (list.contains(num.get(i))) {
				// 选择不重复的数字放进list
				continue;
			}
			list.add(num.get(i));
			System.out
					.println("4. the current list in for loop after list.add is: "
							+ list);
			permutHelper(result, list, num); // 递归函数，这里要看递归的层数有多少。
			list.remove(list.size() - 1); // 递归结束后，会调用remove 函数，递归了多少层就会向上多少层。
			System.out.println("4-1 .list after list.remove(list.size()-1)): "
					+ list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> source = new ArrayList<Integer>();
		source.add(1);
		source.add(2);
		source.add(3);
		System.out.println("the final result is: " + PermutList(source));

	}

}
