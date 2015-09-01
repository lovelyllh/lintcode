package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Collections;

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



TIME: 227 ms*/
public class SubSetsII2 {

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(
			ArrayList<Integer> num) {
		ArrayList<ArrayList<Integer>> subResult = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sublist = new ArrayList<Integer>();

		if (num == null) {
			return subResult;
		}
		// sort the arraylist first
		Collections.sort(num);
		// call help function
		subHelper(subResult, sublist, num, 0);
		return subResult;
	}

	public static void subHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, ArrayList<Integer> num, int pos) {

		result.add(new ArrayList<Integer>(list));

		for (int i = pos; i < num.size(); i++) {
			// backtrack
			if (i != pos && num.get(i) == num.get(i - 1)) {
				continue;
			}

			list.add(num.get(i));
			System.out.println(list);
			subHelper(result, list, num, i + 1);

			list.remove(list.size() - 1);
			System.out.println("list after list.remove(list.size()-1)): "
					+ list);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> source = new ArrayList<Integer>();

		source.add(1);
		source.add(2);
		source.add(2);

		System.out.println("the final result is: " + subsetsWithDup(source));

	}
}
