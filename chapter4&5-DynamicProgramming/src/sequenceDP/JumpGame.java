/*Jump Game
question: http://www.lintcode.com/en/problem/jump-game/
answer:  http://www.jiuzhang.com/solutions/jump-game/

Given an array of non-negative integers, you are initially positioned at the first index of 
the array. Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.

Note
This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).
The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to 
let you learn how to use this problem in dynamic programming ways. If you finish it in 
dynamic programming ways, you can try greedy method to make it accept again.
*/
package sequenceDP;

//version1: dynamic programming

public class JumpGame {
	public static boolean canjump(int[] A){
		if (A == null || A.length == 0){
			return false;
		}
		int n = A.length;
		//1.state: can[i] means if we can jump from 0 to i
		boolean[] can = new boolean[n];
		//2. initialization
		can[0] = true; 
		//default of boolean[] can is false
		//3. function
		for (int i = 1; i < n; i++){ //index of can[]
			for (int j = 0; j < i; j++){//index of A
				if (can[j] && (A[j] + j >= i)){
					can[i] = true;
					break;
				}
			}
		}
		return can[n - 1];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		int[] A1 = {3,2,1,0,4};
		System.out.println(canjump(A));
		System.out.println(canjump(A1));
		
	}

}
