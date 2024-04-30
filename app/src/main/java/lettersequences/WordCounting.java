package lettersequences;

import java.util.HashMap;

public class WordCounting {
    public static void main(String[] args) {
        System.out.println(wordCounting("aaaccc", 3));
    }

    public static int wordCounting(String word, int k) {
        int count = 0;
        for (int i = 0; i <= word.length() - k; i++) {
            for (int j = i + k - 1; j < word.length(); j++) {
                if (kCount(word, i, j, k)) {
                    count += word.length() - j;
                    break;
                }
            }
        }
        return count;
    }

    public static boolean kCount(String word, int st, int end, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] w = word.toCharArray();
        for (int i = st; i <= end; i++) {
            map.put(w[i], map.getOrDefault(w[i], 0) + 1);
            int count = map.get(w[i]);
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}
