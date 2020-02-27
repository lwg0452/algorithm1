package dynamic.programming._5LongestPalindromicSubstring;

class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            int subLen = Math.max(maxLength(s, i, i), maxLength(s, i - 1, i));
            if (subLen > end - start + 1) {
                start = i - subLen / 2;
                end = start + subLen - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    private int maxLength(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }
}
