package org.hhraymond.algo.string;

import java.util.Arrays;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。



 * @author hhraymond
 * @since 2019-09-19
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("是否字母异位: " + isAnagram(s, t));
    }

    /**
    * 解析：
     首先，我们要了解什么是字母异位词

     口水话就是长度一样，所含一样的字母就是字母异位词，由这个思路我们知道，长度不一样那么直接pass，这是一个前提，
     长度一样才能进行下面的判断。之后就是我们如何判断所含字母一样呢？，我的想法是用数组，然后进行排列，把他们排列的结果一一对比就行了。

     数组排列的方法为 Arrays.sort(s)，转化数组的方法为 toCharArray(s);数组的比较方法为Arrays.equals(s,t);

     原文链接：https://blog.csdn.net/JockLiu/article/details/99708178
    * */

    public static boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();//将s字符串转换为数组
        char[] tt = t.toCharArray();//将t字符串转换为数组

        if(ss.length != tt.length) return false;//长度不等，直接pass

        Arrays.sort(ss);//排列组合
        Arrays.sort(tt);

        return Arrays.equals(ss,tt);//看他们各自拼接的组合有无相等的可能

    }


    /**
     *
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     *
     * 就是对字母异位词的理解，意思就是两个单词的组成字符是一样的

     那么题目就变成了判读两个字符串的组成元素是否是一样的，我们用两个数组获取字符串的所有组成元素，然后排序后比较是否相等:

     func isAnagram(_ s: String, _ t: String) -> Bool {

     var sArr = [String]()
     for character in s { //将字符串转为数组
     sArr.append(String(character))
     }

     var tArr = [String]()
     for character in t { //将字符串转为数组
     tArr.append(String(character))
     }

     return sArr.sorted() == tArr.sorted()
     }
     */

}
