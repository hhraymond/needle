package org.hhraymond.algo.string;

/**
 * 马拉车算法
 * @author hhraymond
 * @since 2019-01-08
 */
public class Manacher {

    public static void main(String[] args) {
        String str1 = Manacher.longestPalindrome("babcbabcbaccba");
        System.out.println("回文长度: " + str1.length() + ", 回文: " + str1);
    }

    /******
     * 问题：给定一个字符串 s，找到 s 中最长的回文子串
     * https://segmentfault.com/a/1190000016239464
     如：babcbabcbaccba
     回文长度: 9, 回文: abcbabcba
     解答思路：
     1、传统思路大概是，遍历每一个字符，以该字符为中心向两边查找。其时间复杂度为O(n2)
     2、利用前半段已经计算过的回文长度，来辅助、加速后半段的回文长度，达到时间复杂度为O(n)
     ******/
    public static String longestPalindrome(String s) {
        // 改造字符串，每个字符间添加#。添加头^尾$两个不同的字符用于消除边界判断
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0, len = s.length(); i < len; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");

        int c = 0, r = 0, len = sb.length(), centerIndex = 0, maxLen = 0;
        int[] p = new int[len];

        for (int i = 1; i < len - 1; i++) {
            // 相当于 c - (i - c)
            int iMirror = 2 * c - i;
            p[i] = r > i ? Math.min(r - i, p[iMirror]) : 0;
            System.out.println("c: " + c + ", r: " + r +  ", i: " + i + ", iMirror: " + iMirror + ", p[i]: " + p[i]);
            // 基于当前点为中心扩展寻找回文
            while (sb.charAt(i - 1 - p[i]) == sb.charAt(i + 1 + p[i])) {
                p[i]++;
            }
            // 如果扩展后的右边界值大于当前右边界值则更新
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
            // 寻找最大值与中心点
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int beginIndex = (centerIndex - 1 - maxLen) / 2;
        return s.substring(beginIndex, beginIndex + maxLen);
    }
}
