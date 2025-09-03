import java.util.Arrays;
// top down apporach
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return TD(nums, 0, dp);
    }

    private int TD(int[] arr, int i, int[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];
        int rob = arr[i] + TD(arr, i + 2, dp);
        int not = TD(arr, i + 1, dp);
        return dp[i] = Math.max(rob, not);
    }
}
