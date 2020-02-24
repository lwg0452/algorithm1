package hash.table.and.set._242ValidAnagram;

import java.util.Arrays;

class Solution2 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
       int []check1 = new int[26];
       int []check2 = new int[26];
       for (int i = 0; i < s.length(); i++) {
           check1[s.charAt(i)-'a']++;
           check2[t.charAt(i)-'a']++;
       }
       return Arrays.equals(check1, check2);
    }

    public static void main(String args[]) {
        System.out.println(isAnagram("avbn","vanb"));
    }
}
