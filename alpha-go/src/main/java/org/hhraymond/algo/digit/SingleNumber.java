package org.hhraymond.algo.digit;

/**
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author hhraymond
 * @since 2019-09-01
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] x= {4,1,2,1,2};
        System.out.println(SingleNumber(x));
    }


    public static int SingleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
            result ^=nums[i];
        return result;
    }
}
