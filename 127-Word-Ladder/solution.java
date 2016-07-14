
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<String> queue = new ArrayDeque<>();
		queue.add(beginWord);
		int count = 1;
		while (!queue.isEmpty()) {
			count++;

			int size = queue.size();
			while (size-- > 0) {
				char[] charArray = queue.poll().toCharArray();
				List<String> transitionList = bfsHelper(charArray, wordList);
				
				if (transitionList.contains(endWord)) {
					return count;
				}

				queue.addAll(transitionList);

			}
		}
		return 0;
	}

	private List<String> bfsHelper(char[] charArray, Set<String> wordList) {
		List<String> transitionList = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			char originalChar = charArray[i];
			for (char c = 'a'; c <= 'z'; c++) {
				charArray[i] = c;
				String newWord = String.valueOf(charArray);
				if (wordList.contains(newWord)) {
					transitionList.add(newWord);
					wordList.remove(newWord);
				}
			}
			charArray[i] = originalChar;
		}

		return transitionList;
	}
}