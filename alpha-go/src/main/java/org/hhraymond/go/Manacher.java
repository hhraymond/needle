package org.hhraymond.go;

/**
 * @author huangzhen@u51.com
 * @since 2019-01-08
 */
public class Manacher {

    public static void main(String[] args) {
        String str1 = Manacher.longestPalindrome("abccb");
        System.out.println(str1);
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
            int iMirror = 2 * c - i; // 相当于 c - (i - c)

            p[i] = r > i ? Math.min(r - i, p[iMirror]) : 0;

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

    private static String a = "abccb";
    private static char s[] = a.toCharArray();
    private static char s_new[];
    private static int p[];

    public static int Init()
    {
        int len = s.length;
        s_new[0] = '$';
        s_new[1] = '#';
        int j = 2;

        for (int i = 0; i < len; i++)
        {
            s_new[j++] = s[i];
            s_new[j++] = '#';
        }

        s_new[j] = '\0';  // 别忘了哦

        return j;  // 返回 s_new 的长度
    }

    public static int Manacher2()
    {
        int len = Manacher.Init();  // 取得新字符串长度并完成向 s_new 的转换
        int max_len = -1;  // 最长回文长度

        int id = 0;
        int mx = 0;

        for (int i = 1; i < len; i++) {
            if (i < mx) {
                // 需搞清楚上面那张图含义, mx 和 2*id-i 的含义
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }

            // 不需边界判断，因为左有'$',右有'\0'
            while (s_new[i - p[i]] == s_new[i + p[i]]) {
                p[i]++;
            }
            // 我们每走一步 i，都要和 mx 比较，我们希望 mx 尽可能的远，这样才能更有机会执行 if (i < mx)这句代码，从而提高效率
            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }

            max_len = Math.max(max_len, p[i] - 1);
        }

        return max_len;
    }

}
