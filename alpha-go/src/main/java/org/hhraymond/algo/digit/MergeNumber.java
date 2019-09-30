package org.hhraymond.algo.digit;

/**
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]

 * @author hhraymond
 * @since 2019-09-02
 */
public class MergeNumber {
    public static void main(String[] args) {
        int[] x= {1,2,3,0,0,0};
        int[] y= {2,5,6};

        System.out.println("x.len: " + x.length + ", y.len: " + y.length);
        //merge2(x, x.length, y, y.length);
        //merge2(x, 3, y, 3);
        merge(x, 3, y, 3);

        for(int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
        System.out.println("");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m - 1;
        int l = n - 1;
        int len = m + n - 1;
        for(; k >=0 && l >= 0;) {
            if (nums1[k] >= nums2[l]) {
                nums1[len] = nums1[k];
                nums1[k] = 0;
                k--;
            } else {
                nums1[len] = nums2[l];
                l--;
            }
            len--;
        }
        for(; l >=0; l--, len--) {
            nums1[len] = nums2[l];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int len = m + n - 1;//从后面sum1空的往前存储
        while (i>=0 && j>=0) {
            if (nums1[i] >= nums2[j]) {
                nums1[len--] = nums1[i--];
            } else {
                nums1[len--] = nums2[j--];
            }
        }
        //如果先存储完sum2那么sum1剩下的不用比较 本来就在sum1里面了
        while(j>=0) {//先存储完sum1剩下sum2的继续存储sum1里面
            nums1[len--] = nums2[j--];
        }
    }
}
