package recursion.and.devide.and.conquer._438FindAllAnagramsInAString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] symbol = new int[26];
        for (char c : p.toCharArray()) {
            symbol[c - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (symbol[s.charAt(i) - 'a'] == 0) {
                continue;
            }
            int[] test = new int[26];
            for (int j = 0; j < p.length(); j++) {
                if (symbol[s.charAt(i + j) - 'a'] == 0) {
                    i = i + j;
                    break;
                }
                test[s.charAt(i+j) - 'a']++;
            }
            if (Arrays.equals(symbol, test)) {
                res.add(i);
            }
        }
        return res;
    }
}
