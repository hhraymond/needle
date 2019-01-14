package org.hhraymond.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzhen@u51.com
 * @since 2019-01-12
 */
public class StringManager {
    public static void main(String[] args) {
        int i = StringManager.lengthOfLongestSubstring("aabacda");
        System.out.println("lengthOfLongestSubstring: " + i );

        String[] strs = new String[] {"flower","flow","flight"};
        System.out.println("longestCommonPrefix: " + StringManager.longestCommonPrefix(strs));
    }

    /******
     * 问题：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * https://www.cnblogs.com/ariel-dreamland/p/8668286.html
     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     解答思路：
     1、辅助Map
     2、记录左、右，两个指针，两个差值，取最大
     ******/
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]，左边界i，右边界j
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            System.out.println("i: " + i + ", j: " + j + ", ans: " + ans + ", map: " + map.toString());
        }
        return ans;
    }

    /******
     * 问题：查找字符串数组中的最长公共前缀
     * https://blog.csdn.net/qq_14927217/article/details/72955791
     输入: ["flower","flow","flight"]
     输出: "fl"

     解答思路：
     1、
     2、
     ******/
    public static String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs.length==0){
            return "";
        }
        int min=Integer.MAX_VALUE;
        String minStr="";
        for(int i=0;i<strs.length;i++){
            if(min>strs[i].length()){
                minStr=strs[i];
                min=strs[i].length();
            }
        }
        if(min==0){
            return "";
        }
        for(int i=min;i>=0;i--){
            String standard=minStr.substring(0, i);
            int j=0;
            for(j=0;j<strs.length;j++){
                if(strs[j].substring(0, i).equals(standard)){
                    continue;
                }else{
                    break;
                }
            }
            if(j==strs.length){
                return standard;
            }
        }
        return "";
    }

}
