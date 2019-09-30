package org.hhraymond.algo.string;

import java.util.*;

/**
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.

 * @author hhraymond
 * @since 2019-09-19
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s =  "loveleetcode";
        String s1 =  "ccc";
        String s2 =  "bd";
        System.out.println(s + ": " + firstUniqChar(s));
        System.out.println(s1 + ": " + firstUniqChar2(s1));
        System.out.println(s2 + ": " + firstUniqChar(s2));
    }

    public static int firstUniqChar(String s) {
        Set<Character> c = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            boolean isUniq = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isUniq = false;
                    break;
                }
            }
            if (isUniq) {
                if (c.contains(s.charAt(i))) {
                    continue;
                } else {
                    return i;
                }
            }
            c.add(s.charAt(i));
        }

        return -1;
    }

    // 参照别人的：
    public static int firstUniqChar2(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i], i);
            }
            else{
                map.put(chars[i], -1);
            }
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() != -1)
                return entry.getValue();
        }

        return -1;
    }



}
