/*Jump Game II
question: http://www.lintcode.com/en/problem/jump-game-ii/
answer:  http://www.jiuzhang.com/solutions/jump-game-ii/

Given an array of non-negative integers, you are initially positioned at the first index
of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
then 3 steps to the last index.)
*/
package sequenceDP;

public class JumpGameII {
	public static int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        //1. state: minstep[i] means the minimum jump from 0 to i
        int[] minstep = new int[n];
        //2. initialization
        minstep[0] = 0;
        //3. function
        for (int i = 1; i < n; i++){
            minstep[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if (A[j] + j >= i && minstep[j] != Integer.MAX_VALUE){
                    minstep[i] = Math.min(minstep[j] + 1, minstep[i]);
                }
            }
        }
        //4. answer
        return minstep[n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0,4};
		System.out.println(jump(A));

	}

}
