package LEETCODE.DAY1;

public class jumpgame {
    public int jump(int[] nums) {
        // 只关心跳跃次数
        // 贪心：每次跳跃都选择能跳到最远位置的点
        // 记录当前能跳到的最远位置
        // 遍历数组，更新能跳到的最远位置
        // 当遍历到当前能跳到的最远位置时，跳跃次数加1，并更新当前能跳到的最远位置
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                // 触及边界时更新跳跃次数与最远位置
                currentEnd = farthest;
            }
        }
        return jumps;
    }
    
    public boolean canJump(int[] nums) {
        int maxStep = nums[0];
        for(int i=0;i<=Math.min(maxStep, nums.length-1);i++){
            maxStep = Math.max(maxStep, nums[i] + i);
            if(maxStep >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
