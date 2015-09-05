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
