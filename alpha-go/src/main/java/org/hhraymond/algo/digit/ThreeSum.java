package org.hhraymond.algo.digit;

import java.util.*;

/**
 * @author hhraymond
 * @since 2019-07-15
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] y = {-1, 0, 1, 2, -1, -4};
        System.out.println("三个元素和为0 : " + ThreeSum.threeSum(y));
    }


    /*******
     * 问题：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

     满足要求的三元组集合为：
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     解答思路：
     1、
     2、。
     ******/
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //[-4, -1, -1, 0, 1, 2]
        //Set<List<Integer>> sumZero = new HashSet<>();
        List<List<Integer>> sumZero = new ArrayList<>();
        for (int i = 0; i < nums.length -2; i++) {
//            if(i >= 1 && nums[i] == nums[i-1]) {
//                continue;
//            }
            for (int j = i + 1; j < nums.length - 1; j++) {
//                if(nums[j] == nums[j-1]) {
//                    continue;
//                }
                int k = j + 1;
                while (k < nums.length) {
                    if(nums[i] + nums[j] + nums[k] < 0) {
                        k++;
                    } else if(nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    } else {
                        sumZero.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        k++;
                    }
                }
            }
        }
        //return new ArrayList<>(sumZero);
        return sumZero;
    }

}
