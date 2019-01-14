package org.hhraymond.algo.digit;

import java.util.HashSet;
import java.util.Set;

/**
 * 原文：https://blog.csdn.net/guoyuguang0/article/details/50969938
 * @author hhraymond
 * @since 2019-01-09
 */
public class Solution {
    public static void main(String[] args) {
        int[] x={7, 3, 5, 1, 2, 3, 4, 6, 9, 4};
        int i = Solution.longestConsecutive(x);
        int j = Solution.getMinuteMin(x);
        System.out.println("无序数组中查找最长连续序列: " + i);
        System.out.println("无序数组中找到两个元素使得相差最小值 : " + j);
    }

    /******
     * 问题：在无序数组中查找最长连续序列
     解答思路：
    1、最笨的方法，首先将无序数组排序，然后依次遍历查找最长连续序列。时间复杂度为O(nlgn)，空间复杂度为O(1)。
    2、首先将元素存入HashSet，然后逐个遍历原数组。判断当前遍历的元素-1在不在set中，在就跳过，不在就以该元素为开始逐次+1,遍历是否在set中，记录最长的长度。时间复杂度为O(n)，空间复杂度为O(n)。
    ******/
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int val = num;
                while (set.remove(val++)) {
                }
                max = Math.max(max, val - num - 1);
            }
        }
        return max;
    }

    /*******
     * 问题：无序数组中找到两个元素使得相差最小值
     解答思路：
     1、先将数组排序，依次遍历查找相差最小值。时间复杂度为O(nlgn)，空间复杂度为O(1)。
     2、用桶排序将原数组A放入数组B中，遍历数组B，找到相差的最小值。时间复杂度为O(n)，空间复杂度为O(m)，m为数组A中最大的元素。
     ******/
    public static int getMinuteMin(int[] val) {
        if (val.length < 2) return 0;
        int maxValOfA = val[0];
        for (int i = 1; i < val.length; i++) maxValOfA = Math.max(maxValOfA, val[i]);
        //初始化桶
        int[] bucket = new int[maxValOfA + 1];
        for (int i = 0; i < val.length; i++) {
            if (bucket[val[i]] != 0) return 0;
            bucket[val[i]]++;
        }
        //桶中的数是有序的，遍历桶找到相减的最小值
        int minuteMin = Integer.MAX_VALUE;
        int start = -1, end = -1;
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] != 0) {
                if (start == -1) start = j;
                else {
                    end = j;
                    minuteMin = Math.min(minuteMin, end - start);
                    start = j;
                }
            }
        }
        return minuteMin;
    }
}
