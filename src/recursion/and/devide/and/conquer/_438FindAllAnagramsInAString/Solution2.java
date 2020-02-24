package recursion.and.devide.and.conquer._438FindAllAnagramsInAString;

import java.util.*;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }
        int[] symbol = new int[26];
        int[] test = new int[26];
        for (char c : p.toCharArray()) {
            symbol[c - 'a']++;
        }

        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            test[str[i] - 'a']++;
            if (i >= p.length()) {
                test[str[i - p.length()] - 'a']--;
            }
            if (Arrays.equals(test, symbol)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
