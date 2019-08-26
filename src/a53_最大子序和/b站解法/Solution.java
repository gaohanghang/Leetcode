package a53_最大子序和.b站解法;

public class Solution {

    // time : O(n) space : O(n)
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
        [1, 3, -5, 2]

        res = 1 sum = 1
        sum = -1
        res = 4
     */
    // time : O(n) space : O(1)
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
