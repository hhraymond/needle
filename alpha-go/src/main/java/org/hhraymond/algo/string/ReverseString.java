package org.hhraymond.algo.string;

/**
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @author hhraymond
 * @since 2019-09-12
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ",");
        }
        System.out.println("");
        ReverseString.reverseString(s);
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ",");
        }
    }

    public static void reverseString(char[] s) {
        if(s == null) return;
        int len = s.length - 1;
        for(int i = 0; i < s.length / 2; i++, len--) {
            char a = s[i];
            s[i] = s[len];
            s[len] = a;
        }
    }
}
