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

//versionn2: GREEDY
public class JumpGame2 {
	public static boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0){
            return false;
        }
        int n = A.length;
        int farthest = A[0];
        //initialization
        for (int i = 1; i < n; i++){
            if (farthest >= i && A[i] + i >= farthest){
                farthest = A[i] + i;
            }
        }
        return farthest >= n - 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		int[] A1 = {3,2,1,0,4};
		System.out.println(canJump(A));
		System.out.println(canJump(A1));

	}

}
