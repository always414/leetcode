public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null ^ t == null) {
            return false;
        }
        
        if (s == null && t == null) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(i) + 1);
        }         
        
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer freq = map.get(c);
            if (freq == null) return false;
            freq -= 1;
            if (freq == 0) {
                map.remove(c);
            } else {
                map.put(c, freq);
            }
        }
        
        return map.isEmpty();
        
    }
}