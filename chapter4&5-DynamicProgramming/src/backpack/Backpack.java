/*Backpack
question: http://www.lintcode.com/en/problem/backpack/
answer: http://www.jiuzhang.com/solutions/backpack/

Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Note
You can not divide any item into small pieces.

Challenge
O(n x m) time and O(m) memory.
O(n x m) memory is also acceptable if you do not know how to optimize memory.
*/
package backpack;

public class Backpack {
	public static int backpack(int[] nums, int m){
		if (nums == null || nums.length == 0 || m == 0){
			return 0;
		}
		int n = nums.length;
		//1. state:size[i][j] means we choose the numbers from the first i of nums array
		//and the size doesn't exceed j
		int[][] size = new int[n + 1][m + 1]; 	
		//2. initialization
		/*for (int i = 0; i < n + 1; i++){
			size[i][0] = 0;
		}*/
		for (int j = 0; j < m + 1; j++){
			size[0][j] = 0;
		}
		//3. function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < m + 1; j++){
				if (nums[i - 1] > j){
					size[i][j] = size[i - 1][j];
				}else{//nums[i - 1] < j
					size[i][j] = Math.max(size[i - 1][j], nums[i - 1] + size[i - 1][j - nums[i - 1]]);
				}				
			}			
		}
		//4. answer
		return size[n][m];		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,8,5};
		int m = 10;
		System.out.println(backpack(nums, m));
	}
}
