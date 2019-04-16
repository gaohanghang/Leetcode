package a5最长回文子串;

import com.sun.tools.corba.se.idl.StringGen;

public class Solution {
    public static void main(String[] args) {

    }

    /*
        j = 4
        b a b a d
        i = 2
     */

    // time : O(n^2) space : O(n^2);
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }


    /*
        b a b a d
        left = 0 right 4
     */
    String res = "";
    // 中心扩散法 time : O(n^2) space : O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i , i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
}
