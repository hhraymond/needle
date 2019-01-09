package org.hhraymond.algo;

/**
 * @author huangzhen@u51.com
 * @since 2019-01-08
 */
public class Manacher {

    public static void main(String[] args) {
        String str1 = Manacher.longestPalindrome("babcbabcbaccba");
        System.out.println("回文长度: " + str1.length() + ", 回文: " + str1);
    }


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
