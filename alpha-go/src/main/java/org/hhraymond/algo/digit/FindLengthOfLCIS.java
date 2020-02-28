package org.hhraymond.algo.digit;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 *
 * 输入: [100, 4, 200, 1, 3, 2]
   输出: 4
   解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

 示例 1:

 输入: [1,3,5,4,7]
 输出: 3
 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 示例 2:

 输入: [2,2,2,2,2]
 输出: 1
 解释: 最长连续递增序列是 [2], 长度为1。
 ————————————————
 版权声明：本文为CSDN博主「有理想的番茄」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/weixin_43777983/article/details/96707467
 *
 *
 * 答案还有问题。。
 *
 * @author hhraymond
 * @since 2019-07-15
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] y = {100, 4, 200, 1, 3, 2}; // 1, 2, 3, 4
        //int[] y = {1,3,5,4,7,10,13,16,18,11,25,12}; // 1,3,4,5,7,10,11,12,13,16,18,25
        System.out.println("最长连续递增序列是1: " + FindLengthOfLCIS.findLengthOfLCIS(y));
        System.out.println("最长连续递增序列是2: " + FindLengthOfLCIS.find(y));
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


    public static int find(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;

        int start = 0,end = 1;

        while (end < nums.length){
            if (nums[end] > nums[end-1]){
                end++;
                continue;
            }
            if (end -start > count) {
                count = end - start;
            }
            start = end++;
        }

        if (end -start > count) {
            count = end - start;  //整个数组都为递增
        }
        return count;
    }
}
