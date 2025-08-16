import java.util.Arrays;
class Solution{
    public long perfectPairs(int[] nums){
        int n = nums.length;
        if (n < 2) return 0L;
        long[] absVals = new long[n];
        for (int i = 0; i < n; i++) absVals[i] = Math.abs((long) nums[i]);
        Arrays.sort(absVals);
        long count = 0L;
        int right = 0;
        for (int left = 0; left < n; left++) {
            if (right < left + 1) right = left + 1;
            while (right < n && absVals[right] <= 2L * absVals[left]) right++;
            count += (right - 1) - left;
        }
        return count;
    }
}
