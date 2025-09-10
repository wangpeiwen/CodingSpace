// LEETCODE HOT 100

package coding.java;

import java.util.Arrays;

public class test {
    // NO.74 https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-100-liked
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        // 思路：将二维矩阵看作一维数组进行二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    // NO.31 https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i= n-2;
        // 从后往前找到第一个升序对
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果整个数组是降序排列，说明已经是最大排列，直接排序成最小排列
        if(i<0){
            Arrays.sort(nums);
            return;
        }
        // 从后往前找到第一个比nums[i]大的数
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        // 交换nums[i]和nums[j]
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // 将交换后位于nums[i]后面的数进行升序排列
        Arrays.sort(nums, i + 1, n);
    }

    public static void main(String[] args) {
        test t = new test();
        // int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        // int target = 3;
        // System.out.println(t.searchMatrix(matrix, target));
        int[] nums = {1, 3, 2};
        t.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}