import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class hzbank {
    public static void main(String[] srgs){
        // number of hzbank
        List<Integer> nums = new java.util.ArrayList<>();
        nums.sort((x,y)->x-y);

        int[] list = {-10,8,2,1,2,6};
        int k = 4;

        System.out.println(maxSumAfterKOperations(list,k));
    }


    // 实现二叉排序树的范围求和
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    public static int maxSumAfterKOperations(int[] nums, int k) {
        int n = nums.length;
        
        // dp[i][j]表示前i个元素做j次操作后的最大和
        int[][] dp = new int[n + 1][k + 1];
        // 初始化dp数组为负无穷（Java默认初始化为0，需要手动设置）
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        // 基准情况：0个元素0次操作和为0
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int maxSum = Integer.MIN_VALUE;
                int currentSum = 0;
                
                // x表示当前这一轮取的元素个数
                int limit = Math.min(j, i);
                for (int x = 0; x <= limit; x++) {
                    if (x > 0) {
                        // 累加当前元素，或仅取当前元素（取最大值）
                        currentSum = Math.max(currentSum + nums[i - x], nums[i - x]);
                    }
                    // 确保之前的状态有效（不是负无穷）
                    if (dp[i - x][j - x] != Integer.MIN_VALUE) {
                        maxSum = Math.max(maxSum, currentSum + dp[i - x][j - x]);
                    }
                }
                
                dp[i][j] = maxSum;
            }
        }
        
        return dp[n][k];
    }
}
