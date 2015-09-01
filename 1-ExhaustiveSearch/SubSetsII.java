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
 ʹ�þ����㷨��ģ�壺
 �ݹ�����
 1. �ȶ������������
 2. ��set������ȡһ�����ֳ������ɣ���Ϊ���Ǳ����������Բ���Ҫȡ��ǰIndex֮ǰ�����֡�
 ����ÿһ��ָ��start�� ѭ��������S[start]Ϊ��ʼԪ�ص�subset�� һ��forѭ�������� �Ѹոռ��뵽��ʱ�Ӽ��е�Ԫ��remove���� Ҳ���ǻ���
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
		 * i��������ı�����Ϊĳһ������еá���һ��Ԫ�ء� i == position --> go depth, when we add
		 * number, we don't care duplicates i != position means back tracking,
		 * already remove one number, i++ which leads i!=position,(i>position
		 * also works) that means second or third or more time, we care about
		 * the duplicate numbers. As they are sorted, we abort and continue
		 */

		for (int i = pos; i < num.length; i++) {
			// // �������ķ�֧ �ؼ� : backtrack
			if (i != pos && num[i] == num[i - 1]) {
				continue;
			}

			list.add(num[i]);
			// ����ÿһ��ָ��start�� ѭ��������S[start]Ϊ��ʼԪ�ص�subset
			// not: subsetsListPara.add(subsetPara)
			/*
			 * pass by reference ����Լ�Ҳ֪���� ����д��ʱ���Ȼ����Ӧ����ֱ��add��lis ����տ�ʼ�ӽ�ȥ��[],
			 * Ȼ�󵱼���[1]��resultʱ, resultʵ������{{1} , {1}}, Ȼ�����[2]��list��, result
			 * add list����� {{1,2}{1,2}{1,2}}. ����Ȼ�ǲ��Եġ�
			 */

			subsetsHelper(result, list, num, i + 1);

			// һ��forѭ�������� �Ѹոռ��뵽��ʱ�Ӽ��е�Ԫ��remove���� Ҳ���ǻ���backtrack��
			list.remove(list.size() - 1);// why?????
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { 1, 2, 2 };
		System.out.println(subsetsNoDup(S));

	}

}
