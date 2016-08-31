public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        while (magazine.length() > 0) {
            if (magazine.startsWith(ransomNote) {
                return true;
            } else {
                magazine = magazine.subString(1);
            }
        }
        
        return false;
        
        
    }
}