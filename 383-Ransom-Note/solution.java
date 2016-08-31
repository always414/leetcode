public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.equals(magazine)) return true;
        
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            chars.putIfAbsent(c, 0);
            
            Integer freq = chars.get(c);
            chars.put(c, freq + 1);
        }
        
        for (int i = 0 ; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            Integer freq = chars.get(c);
            if (freq != null && freq > 0) {
                chars.put(c, freq - 1);
            }
        }
        

        Iterator<Integer> valueItr = chars.values().iterator();
        while (valueItr.hasNext()) {
            Integer i = valueItr.next();
            if (i != 0) {
                return false;
            }
        }
       
        return true;
       
    }
}