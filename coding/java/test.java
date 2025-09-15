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

    // sliding window top k
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     // 1. nums的长度为0, 或k为0
    //     if (nums.length == 0 || k == 0) {
    //         return new int[0];
    //     }
    //     // 2. nums的长度小于等于k
    //     if (nums.length <= k) {
    //         int max = Integer.MIN_VALUE;
    //         for (int num : nums) {
    //             max = Math.max(max, num);
    //         }
    //         return new int[]{max};
    //     }
    //     // i,j为滑动窗口的左右边界
    //     int i=0,j=nums.length-k;
    //     int[] res = new int[nums.length - k + 1];
    //     for()
    // }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        // 使用虚拟头节点简化边界处理
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 处理两个链表共有部分
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10; // 计算进位
            current.next = new ListNode(sum % 10); // 创建新节点存储当前位结果
            current = current.next; // 移动指针
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // 处理l1剩余节点
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }
        
        // 处理l2剩余节点
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l2 = l2.next;
        }
        
        // 处理最后剩余的进位
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // 返回虚拟头节点的下一个节点，即真正的结果链表头
        return dummy.next;
    }

    public static void main(String[] args) {
        test t = new test();
        // int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        // int target = 3;
        // System.out.println(t.searchMatrix(matrix, target));
        // int[] nums = {1, 3, 2};
        // t.nextPermutation(nums);
        // System.out.println(Arrays.toString(nums));
        ListNode l1 = t.new ListNode(2);
        l1.next = t.new ListNode(4);
        l1.next.next = t.new ListNode(3);
        ListNode l2 = t.new ListNode(5);
        l2.next = t.new ListNode(6);
        l2.next.next = t.new ListNode(4);
        ListNode res = t.addTwoNumbers(l1, l2);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}