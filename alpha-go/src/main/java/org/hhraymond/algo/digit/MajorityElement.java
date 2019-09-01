package org.hhraymond.algo.digit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 如 输入: [2,2,1,1,1,2,2]
 *   输出: 2
 * @author hhraymond
 * @since 2019-09-01
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] x= {2,2,1,1,1,2,2};
        System.out.println(majorityElement(x));
        System.out.println(majorityElement2(x));
        System.out.println(majorityElement3(x));
    }


    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            //throw new Exception("input error");
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxKey = nums[0], maxValue = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }


    /**
     * 这道题用摩尔投票法，这种方法是因为题目中说众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 所以设置一个计数器，选定第一个值作为起始值，
     * 然后后面的值如果是这个值那么计数加一，如果不等，那么计数减一，当计数器的值为零时，选取当前值作为新值继续计数。
     * 因为众数肯定大于1/2所以最后计数器不为零的数肯定是众数。
     *
     * @param nums
     * @return
     */

    public static int majorityElement2(int[] nums) {
        int count = 0;
        int num = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    num = nums[i];
                    count++;
                }

            }
        }
        return num;
    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
