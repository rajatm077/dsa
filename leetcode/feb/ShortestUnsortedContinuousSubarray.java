package leetcode.feb;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1,3,2,2,2}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i-1]) continue;
            end = i;
            int j;
            if (start >= 0) {
                j = start;
            } else {
                j = i - 1;
                start = j;
            }
            while (j >= 0 && nums[j] > nums[i]) {
                j--;
            }
            j++;
            start = Math.min(start, j);
            int temp = nums[i-1];
            nums[start] = nums[i];
            nums[i] = temp;

        }
        if (start >= 0) {
            return end - start + 1;
        } else {
            return 0;
        }
    }
}
