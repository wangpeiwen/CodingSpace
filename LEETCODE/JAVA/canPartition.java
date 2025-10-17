package LEETCODE.JAVA;

public class canPartition {
    public boolean CanPartition(int[] nums) {
        // 计算总和
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        // 0-1 背包问题
        // 状态转移方程 dp[i] = dp[i] || dp[i-num]
        for(int num : nums){
            for(int i=target;i>=num;i--){
                dp[i] = dp[i] || dp[i-num];
            }
            if(dp[target]){
                return true;
            }
        }
        return false;
    }
}
