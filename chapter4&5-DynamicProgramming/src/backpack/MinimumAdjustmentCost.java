/*Minimum Adjustment Cost
question: http://www.lintcode.com/en/problem/minimum-adjustment-cost/
answer: http://www.cnblogs.com/yuzhangcmu/p/4153927.html

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Note
You can assume each number in the array is a positive integer and not greater than 100.
*/
package backpack;

import java.util.ArrayList;

public class MinimumAdjustmentCost {
	public static int minAdjustmentcost(ArrayList<Integer> A, int target){
		if (A == null || A.size() == 0){
			return 0;
		}
		int n = A.size();
		//1. state: mincost[i][j] means the minimum cost for the ith of A to change to value j, 
		int[][] mincost = new int[n + 1][101];
		//2. initialization		
		for (int j = 0; j < 101; j++){
			mincost[0][j] = Math.abs(j - A.get(0));
		}
		//3. function
		for (int i = 1; i < n; i++){//a.get(i), the last index is n - 1*/	
			for (int j = 0; j < 101; j++){
				mincost[i][j] = Integer.MAX_VALUE;
				for (int pre = 1; pre < 101; pre++){
					if (Math.abs(j - pre) > target){
						continue;
					}
					mincost[i][j] = Math.min(mincost[i][j], mincost[i - 1][pre] + Math.abs(j - A.get(i)));
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int j = 0; j < 101; j++){
			result = Math.min(result, mincost[n - 1][j]);
		}		
		return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		/*[1,4,2,3]*/
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		int target = 1;
		System.out.println(minAdjustmentcost(A, target));
	}
}
