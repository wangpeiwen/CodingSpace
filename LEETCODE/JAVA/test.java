package LEETCODE.JAVA;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(minCost(cost, x, y));

        String s = in.nextLine();
        System.out.println(minOpNums(s));
    }
    // 环形公路共n站，给定顺时针第i站到第i+1站的花费cost[i],以及最后一站到第一站的花费cost[n-1]，求从x站出发，到y站所需的最小花费
    // 思路：计算顺时针和逆时针的花费，取最小值
    public static int minCost(int[] cost, int x, int y) {
        int n = cost.length;
        int clockwiseCost = 0;
        int counterClockwiseCost = 0;
        // 顺时针花费
        for (int i = x; i != y; i = (i + 1) % n) {
            clockwiseCost += cost[i];
        }
        // 逆时针花费
        for (int i = x; i != y; i = (i - 1 + n) % n) {
            counterClockwiseCost += cost[(i - 1 + n) % n];
        }
        // 返回最小花费
        return Math.min(clockwiseCost, counterClockwiseCost);
    }

    // 给定字符串s，求将所有字母变成相同字母所需的最小操作数
    // 要求每次操作只能将某个字母变成其相邻字母
    // “yab” 操作3次变成“aaa”
    // 思路：枚举目标字母，然后计算将所有字母变成该字母所需的操作数，取最小值
    public static int minOpNums(String s) {
        int n = s.length();
        int minOps = Integer.MAX_VALUE;
        for (char target = 'a'; target <= 'z'; target++) {
            int currentOps = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                // a和z之间的距离是1
                // currentOps += Math.abs(c - target);
                int diff = Math.abs(c - target);
                currentOps += Math.min(diff, 26 - diff);
            }
            minOps = Math.min(minOps, currentOps);
        }
        return minOps;
    }
}
