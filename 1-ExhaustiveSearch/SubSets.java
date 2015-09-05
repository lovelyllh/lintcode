package exhaustiveSearch;
import java.util.ArrayList;
import java.util.Collections;

/*
 * question:
 * Given a set of distinct integers, return all possible subsets.
Example
 If S = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * */

public class SubSets {

	public static ArrayList<ArrayList<Integer>> Subsets(ArrayList<Integer> num) {

		ArrayList<ArrayList<Integer>> subsetsList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList();

		if (num == null) {
			return subsetsList;
		}

		Collections.sort(num);

		subsetsHelper(subsetsList, subset, num, 0);

		return subsetsList;

	}

	public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, ArrayList<Integer> num, int pos) {

		result.add(new ArrayList<Integer>(list)); // add the list itself
		System.out.println("----------------------------");
		System.out.println("1. the current list is: " + list
				+ ", the current result is: " + result);
		System.out.println("----------------------------");
		for (int i = pos; i < num.size(); i++) {// 开始以i为首的子集
			System.out.println("2. current i is: " + i);
			System.out.println("2-1. current pos is: " + pos);
			list.add(num.get(i));
			System.out.println("3. list starts at " + i + " is: " + list);
			subsetsHelper(result, list, num, i + 1);// 加入以i为首的所有子集， e.g：｛1｝，
			// ｛1，2｝， ｛1，2，3｝
			list.remove(list.size() - 1);
			System.out.println("4. list after list.remove(list.size()-1)): "
					+ list);
			System.out.println("5. current i is: " + i);
			System.out.println("5-1. current pos is: " + pos);
		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> source = new ArrayList<Integer>();
		source.add(1);
		source.add(2);
		source.add(3);
		System.out.println("the final result is: " + Subsets(source));

	}

}
