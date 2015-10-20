/*k Sum
question: http://www.lintcode.com/en/problem/k-sum/
answer:   http://www.cnblogs.com/yuzhangcmu/p/4279676.html

Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.
*/
package backpack;

public class KSum {
	public static int ksum(int[] A, int k, int target){
		if (A == null || A.length == 0 || A.length < k){
			return 0;
		}
		int n = A.length;
		int m = target;
		//1.state:sum[i][j][k]means get first j numbers from first i of A, how many 
		//sums matching target k
		int[][][] sum = new int[n + 1][k + 1][m + 1];
		//2.initialization:
		for (int i = 0; i < n + 1; i++){
			sum[i][0][0] = 1;// why??
		}	
		//3.function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < k + 1 && j <= i; j++){
				for (int t = 1; t < m + 1; t++){
					sum[i][j][t] = 0;
					if (A[i - 1] <= t){
						sum[i][j][t] = sum[i - 1][j - 1][t - A[i - 1]] + sum[i - 1][j][t];
					}else{
						sum[i][j][t] = sum[i - 1][j][t];
					}
				}
			}
		}
		
		return sum[n][k][m];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 4};
		int k = 2;
		int target = 5;
		System.out.println(ksum(A, k, target));

	}

}
