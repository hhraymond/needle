/**
 * FindMaxNum.java
 * Copyright 2020 HelloBike , all rights reserved.
 * HelloBike PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package org.hhraymond.algo.matrix;


import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 输入一个非负的整形数组，然后输出使用输入数组里的元素组合成的最大数字
 *  * 如：输入[45, 9 ,7]，输出字符串 “9745”
 *  * 另外，输入数组可以有重复的数字
 *
 * @author hhraymond
 * @date 2020/4/27
 */
public class FindMaxNum {

    public static void main(String[] args) {
        //Integer [] arr2 = {45, 4};
        Integer [] arr2 = {45, 9, 7, 99, 90, 0, 198};
        //Integer [] arr2 = {43, 4};
        findMaxNum(arr2);
    }

    public static void findMaxNum(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return com(String.valueOf(o1), String.valueOf(o2));
            }

            /**
             * 字典序排列
             *
             * @param o1
             * @param o2
             * @return
             */
            private int com(String o1, String o2) {
                int o1l = o1.length();
                int o2l = o2.length();
                int i = 0, j = 0;

                while (i < o1l && j < o2l) {
                    if (o1.charAt(i) == o2.charAt(j)) {
                        if (i == o1l - 1 && j == o2l - 1) {
                            return 0;
                        }

                        if (i < o1l - 1) {
                            i++;
                        }
                        if (j < o2l - 1) {
                            j++;
                        }
                    } else if (o1.charAt(i) < o2.charAt(j)) {
                        return 1;
                    } else if (o1.charAt(i) > o2.charAt(j)) {
                        return -1;
                    }
                }
                return 0;
            }

        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
