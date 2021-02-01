package leetcode.april;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int tempSum = Integer.MIN_VALUE;
        int maxSum = tempSum;
        for (int a: nums) {
            if (a > tempSum && tempSum <= 0) {
                tempSum = a;
            } else {
                tempSum += a;
            }
            if (maxSum < tempSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}
