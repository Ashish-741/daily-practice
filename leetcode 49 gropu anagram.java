import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f).append('#'); // avoid ambiguity
        }
        return sb.toString();
    }
}
