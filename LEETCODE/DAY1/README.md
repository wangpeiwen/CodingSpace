# 经典算法思想总结[https://javaguide.cn/cs-basics/algorithms/classical-algorithm-problems-recommendations.html]
## 贪心算法
### 算法思想
    贪心的本质是选择每一阶段的局部最优，从而达到全局最优。

    <!-- 一般解题步骤
    将问题分解为若干个子问题
    找出适合的贪心策略
    求解每一个子问题的最优解
    将局部最优解堆叠成全局最优解 -->
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