package org.hhraymond.algo.digit;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 *
 * 输入: [100, 4, 200, 1, 3, 2]
   输出: 4
   解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *
 * @author hhraymond
 * @since 2019-07-15
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] y = {1,3,5,4,7,10,13,16,18};
        System.out.println("最长连续递增序列是: " + FindLengthOfLCIS.findLengthOfLCIS(y));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i -1]) {
                j++;
            } else {
                maxLength = Math.max(maxLength, j);
                j = 1;
            }
        }

        return Math.max(maxLength, j);
    }
}
