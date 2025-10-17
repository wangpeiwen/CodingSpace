package LEETCODE.JAVA;

public class change {
    public int changeWays(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for (int j = coin; j <= amount; j++) {
                // 累加使用当前硬币的组合数
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
