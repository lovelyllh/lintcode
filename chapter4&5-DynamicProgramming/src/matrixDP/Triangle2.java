/*triangle
question: http://www.lintcode.com/en/problem/triangle/
answer: http://www.jiuzhang.com/solutions/triangle/

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to 
adjacent numbers on the row below.

Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/
package matrixDP;

import java.util.ArrayList;

//version2: memorize search
public class Triangle2 {
	private int n;
	private int[][] minsum;
	private ArrayList<ArrayList<Integer>> triangle;
	
	public int minimumSum(ArrayList<ArrayList<Integer>> triangle){
		if (triangle == null || triangle.size() == 0){
			return 0;
		}
		this.n = triangle.size();
		this.minsum = new int[n][n];
		this.triangle = triangle;
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				minsum[i][j] = Integer.MAX_VALUE;		
			}
		}		
		return search(0, 0);	
	}
		

	public int search(int i, int j) {
		// TODO Auto-generated method stub
		if (i >= n){
			return 0;
		}
		if (minsum[i][j] != Integer.MAX_VALUE){
			return minsum[i][j];
		}
		int left = search(i + 1, j);
		int right = search(i + 1, j + 1);
		minsum[i][j] = triangle.get(i).get(j) + Math.min(left, right);
		return minsum[i][j];
}

	public void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1.add(2);
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		n2.add(3);
		n2.add(4);
		ArrayList<Integer> n3 = new ArrayList<Integer>();
		n3.add(6);
		n3.add(5);
		n3.add(7);
		ArrayList<Integer> n4 = new ArrayList<Integer>();
		n4.add(4);
		n4.add(1);
		n4.add(8);
		n4.add(3);
		nums.add(n1);
		nums.add(n2);
		nums.add(n3);
		nums.add(n4);
		System.out.println(minimumSum(nums));	
	}

}
