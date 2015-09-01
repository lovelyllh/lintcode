package exhaustiveSearch;
import java.util.ArrayList;
import java.util.Arrays;

/*Given a list of numbers that may has duplicate numbers, return all possible subsets
 * Example:
 * If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 Note
 Each element in a subset must be in non-descending order.
 The ordering between two subsets is free.
 the solution set must not contain duplicate subsets.
 * */
/*needs review(remember)
 /*
 question: http://www.lintcode.com/en/problem/subsets-ii/
 answer: http://www.jiuzhang.com/solutions/subsets-ii/
 使用九章算法的模板：
 递归解决。
 1. 先对数组进行排序。
 2. 在set中依次取一个数字出来即可，因为我们保持升序，所以不需要取当前Index之前的数字。
 对于每一个指针start， 循环加入以S[start]为起始元素的subset， 一层for循环结束后， 把刚刚加入到临时子集中的元素remove掉， 也就是回溯
 backtracking recursive

 time complexity: o(n*2^n)

 TIME: 227 ms*/
public class SubSetsII {

	public static ArrayList<ArrayList<Integer>> subsetsNoDup(int[] source) {

		// new empty subsetList
		ArrayList<ArrayList<Integer>> subsetsList = new ArrayList<ArrayList<Integer>>();
		// new subset
		ArrayList<Integer> subset = new ArrayList<Integer>();
		// corner check
		if (source == null || source.length == 0)
			return subsetsList;

		// sort the array first
		Arrays.sort(source);

		// call help function
		subsetsHelper(subsetsList, subset, source, 0);

		return subsetsList;

	}

	public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] num, int pos) {

		result.add(new ArrayList<Integer>(list));

		/*
		 * i处所代表的变量即为某一层遍历中得「第一个元素」 i == position --> go depth, when we add
		 * number, we don't care duplicates i != position means back tracking,
		 * already remove one number, i++ which leads i!=position,(i>position
		 * also works) that means second or third or more time, we care about
		 * the duplicate numbers. As they are sorted, we abort and continue
		 */

		for (int i = pos; i < num.length; i++) {
			// // 控制树的分支 关键 : backtrack
			if (i != pos && num[i] == num[i - 1]) {
				continue;
			}

			list.add(num[i]);
			// 对于每一个指针start， 循环加入以S[start]为起始元素的subset
			// not: subsetsListPara.add(subsetPara)
			/*
			 * pass by reference 这个自己也知道， 但是写的时候居然理所应当的直接add了lis 比如刚开始加进去是[],
			 * 然后当加入[1]到result时, result实际上是{{1} , {1}}, 然后加入[2]到list后, result
			 * add list变成了 {{1,2}{1,2}{1,2}}. 这显然是不对的”
			 */

			subsetsHelper(result, list, num, i + 1);

			// 一层for循环结束后， 把刚刚加入到临时子集中的元素remove掉， 也就是回溯backtrack。
			list.remove(list.size() - 1);// why?????
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { 1, 2, 2 };
		System.out.println(subsetsNoDup(S));

	}

}
