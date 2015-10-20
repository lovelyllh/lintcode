/*Backpack II

question: http://www.lintcode.com/en/problem/backpack-ii/
answer:  http://www.jiuzhang.com/problem/59/
https://github.com/billryan/algorithm-exercise/blob/master/zh-cn/dynamic_programming/backpack_ii.md

Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value 
can you put into the backpack?

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Note
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Challenge
O(n x m) memory is acceptable, can you do it in O(m) memory?
*/
package backpack;

public class BackpackII {
	public static int maxValue(int[] size, int[] value, int m){
		if (m == 0 || size == null || size.length == 0){
			return 0;
		}
		if (value == null || value.length == 0){
			return 0;
		}
		int n = value.length;
		//1. state:maxvalue[i][j] means the max value of the first i item to fit backpack size m 
		int[][] maxvalue = new int[n + 1][m + 1];//because the loop have i + 1
		//2. initialization
		for (int i = 0; i < n + 1; i++){
			maxvalue[i][0] = 0;
		}
		//3. function
		for (int i = 0; i < n; i++){//not n + 1 because in the loop we have i + 1
			for (int j = 0; j < m + 1; j++){// 0 to m
				if (size[i] > j){//index begin at 0
					maxvalue[i + 1][j] = maxvalue[i][j];
				}else{
					maxvalue[i + 1][j] = Math.max(maxvalue[i][j], value[i] + maxvalue[i][j - size[i]]);
				}
			}
		}
		return maxvalue[n][m];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] size = {2, 3, 5, 7};
		int[] value = {1, 5, 2, 4};
		int m = 10;
		System.out.println(maxValue(size, value, m));
	}
}
