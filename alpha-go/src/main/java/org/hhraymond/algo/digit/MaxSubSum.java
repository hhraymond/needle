package org.hhraymond.algo.digit;

/**
 * 最大子序列和问题
 *
 * @author hhraymond
 * @since 2019-08-07
 */
public class MaxSubSum {

    public static void main(String[] args) {
        int[] data = {8,-2, 6, -1, 5, 4, -7, 2, 3};

        System.out.println("1 最大子序列和为：" + maxSubSum1(data));
        System.out.println("2 最大子序列和为：" + maxSubSum2(data));
        System.out.println("4 最大子序列和为：" + maxSubSum4(data));
        int sum = 0;
        for(int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println(sum);

    }

    public static int maxSubSum4(int[] data) {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < data.length; i++) {
            thisSum += data[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    // 递归，分治
    public static int maxSubSum3(int[] data) {
        return maxSumSec(data, 0, data.length - 1);
    }

    public static int maxSumSec(int[] data, int left, int right) {
        // TODO
        return 0;
    }

    public static int maxSubSum2(int[] data) {
        int maxSum = 0;
        for (int i = 0; i < data.length; i++) {
            int thisSum = 0;

            for (int j = i; j < data.length; j++) {
                thisSum += data[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSum1(int[] data) {
        int maxSum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += data[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
}
