package org.hhraymond.algo.string;

import java.util.ArrayList;

/**
 * 分隔回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 输入: "aab"
 输出:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * @author hhraymond
 * @since 2019-09-12
 */
public class Partition {

    public static void main(String[] args) {
        int flag = 2;
        if (flag == 1) {//获取全部的不为空的回文子字符串
            partion("aab");
        } else if (flag == 2) {//获取S的回文分割方案
            System.out.println(partition("aabbca"));
        }
    }

    /**
     * 检查是否为回文
     *
     * @param s
     * @return
     */
    public static boolean check(String s) {
        String s1 = "";
        char[] c = s.toCharArray();
        /*Character[] ctr=new Character[s.length()];
        byte[] b=s.getBytes();*/
        for (int i = s.length() - 1; i >= 0; i--) {
            /*System.out.println(b[i]);*/
            c[i] = s.charAt(i);
//            System.out.println(c[i]);
            s1 = s1 + c[i];
//            System.out.println(s1);
        }
        if (s1.equals(s)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取所有不为空的回文子串
     *
     * @param str
     */
    public static void partion(String str) {
        String substr = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() + 1; j++) {//注意这里j的取值范围，因为截取函数substring(i,j)包含i不包含j
                substr = str.substring(i, j);
                if (!("".equals(substr)) && check(substr)) {//打印所有不为空的回文子串
                    System.out.println("i:" + i + "j:" + j + "substr:" + substr);
                }

            }
        }
    }

    /**
     * 获取字符串S的回文分割法集合
     *
     * @param s
     * @return
     */
    public static ArrayList<ArrayList<String>> partition(String s) {
        // write your code here
        ArrayList<ArrayList<String>> pLists = new ArrayList<ArrayList<String>>();
        int length = s.length();
        ArrayList<String> array = new ArrayList<String>();
        if (s.length() == 0 || s == null) {
            pLists.add(array);
            return pLists;
        }

        helper(s, pLists, array, 0);
        return pLists;
    }

    public static void helper(String s, ArrayList<ArrayList<String>> pLists,
                              ArrayList<String> array, int start) {
        if (start == s.length()) {
            pLists.add(array);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s.substring(start, i + 1))) {
                ArrayList<String> tmp = new ArrayList<>(array);
                tmp.add(s.substring(start, i + 1));
                helper(s, pLists, tmp, i + 1);
            }
        }

    }
}
