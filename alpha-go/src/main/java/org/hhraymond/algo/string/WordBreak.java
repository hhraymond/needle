package org.hhraymond.algo.string;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：
 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false

 分析：
 用dp[i]记录到i为止的字符串能够由1个或多个单词拼接而成，遍历字符串嵌套遍历字典 -> O(n*k)。
 需要每次遍历给定字典中的字符串，查看当前字符串的指定长度子串是否与字典中的某字符串相同，若相同，则置dp[i+dict[j].length()] = true
 最后返回dp[s.length()]即可。

 *
 *
 * @author hhraymond
 * @since 2019-09-17
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("apple", "pen");
        String s = "applepenapple";
        System.out.println(wordBreak(s, wordDict));

        List<String> wordDict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s2 = "catsandog";
        System.out.println(wordBreak(s2, wordDict2));
    }

    // 通过debug，可清晰看到，匹配到一个word后，向后跳word的长度，然后继续匹配
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word: wordDict) {
                if (i+word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
