# 经典算法思想总结[https://javaguide.cn/cs-basics/algorithms/classical-algorithm-problems-recommendations.html]
## 贪心算法
### 算法思想
    贪心的本质是选择每一阶段的局部最优，从而达到全局最优。

<!-- 一般解题步骤将问题分解为若干个子问题找出适合的贪心策略求解每一个子问题的最优解将局部最优解堆叠成全局最优解 -->
#### 455.分发饼干：https://leetcode.cn/problems/assign-cookies/
类似于内存分配的best-fit算法
#### 121.买卖股票的最佳时机：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
记录此前最低点与最大利润
#### 122.买卖股票的最佳时机 II：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
动态规划思想/线段拼接
#### 55.跳跃游戏：https://leetcode.cn/problems/jump-game/
实际上只关心能跳到的最远距离
#### 45.跳跃游戏 II：https://leetcode.cn/problems/jump-game-ii/
记录当前能跳到的最远位置，遍历数组，更新能跳到的最远位置，当遍历到当前能跳到的最远位置时，跳跃次数加1，并更新当前能跳到的最远位置

## 动态规划
### 算法思想
    动态规划中每一个状态一定是由上一个状态推导出来的，这一点就区分于贪心，贪心没有状态推导，而是从局部直接选最优的。

    经典题目：01 背包、完全背包

<!-- 一般解题步骤：确定 dp 数组（dp table）以及下标的含义确定递推公式dp 数组如何初始化确定遍历顺序举例推导 dp 数组 -->
#### 509.斐波那契数：https://leetcode.cn/problems/fibonacci-number/
f(n) = f(n-1) + f(n-2)
#### 746.使用最小花费爬楼梯：https://leetcode.cn/problems/min-cost-climbing-stairs/
dp[0] = 0, dp[1] = 0
dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
#### 416.分割等和子集：https://leetcode.cn/problems/partition-equal-subset-sum/
维护一个容量为 sum/2 的背包，遍历物品，更新背包容量
#### 518.零钱兑换：https://leetcode.cn/problems/coin-change-ii/
完全背包问题，维护一个容量为 amount 的背包，遍历物品，更新背包容量
dp[j] += dp[j - coin];
#### 647.回文子串：https://leetcode.cn/problems/palindromic-substrings/
1. 暴力枚举所有子串，判断是否为回文串
2. 动态规划，dp[i][j] 表示 s[i..j] 是否为回文串 维护二维数组 dp
#### 516.最长回文子序列：https://leetcode.cn/problems/longest-palindromic-subsequence/