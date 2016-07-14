import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	Queue<String> queue = new ArrayDeque<>();
    	queue.add(beginWord);
    	int count = 1;
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		count ++;
    		while (size-- > 0) {
    			char[] charArray = queue.poll().toCharArray();
    			for (int i = 0; i < charArray.length; i++) {
    				char originalChar = charArray[i];
    				for (char c = 'a'; c <= 'z'; c++) {
    					charArray[i] = c;
    					String newWord = String.valueOf(charArray);
    					if (newWord.equals(endWord)) {
    						return count;
    					}
    					if (wordList.contains(newWord)) {
//    						System.out.println(newWord);
    						queue.add(newWord);
    						wordList.remove(newWord);
    					} 
    				}
    				charArray[i] = originalChar;
    			}
    		}
    	}
        return 0;
    }
}