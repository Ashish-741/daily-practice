//top down apporach
class Solution {
    int[][] dp; // dp[i][a] = ways using coins from i..end to make amount a

    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return Coin_Change(coins, amount, 0);
    }

    private int Coin_Change(int[] coin, int amount, int i){
        if(amount == 0) return 1;
        if(i == coin.length) return 0;

        if(dp[i][amount] != -1) return dp[i][amount];

        int inc = 0;
        if(amount >= coin[i]) {
            inc = Coin_Change(coin, amount - coin[i], i);
        }
        int exc = Coin_Change(coin, amount, i+1);

        return dp[i][amount] = inc + exc;
    }
}

//bottom up apporach


class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case: 1 way to make 0

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}









