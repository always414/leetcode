import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;

import org.omg.CORBA.TRANSACTION_MODE;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> currentTransaction = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(currentTransaction);
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	Set<String> levelWord = new HashSet<>();
        	boolean find = false;

        	while (size -- > 0) {
        		// do level bfs 
        		currentTransaction = queue.poll();
        		List<List<String>> newTransactions = bfsHelper(currentTransaction, endWord, wordList, levelWord);

        		for (List<String> transaction : newTransactions) {
        			String childWord = transaction.get(transaction.size() - 1);
        			levelWord.add(childWord);
        			if (childWord.equals(endWord)) {
        				res.add(transaction);
        				find = true;
        			}
        		}
        		if (!find) {
        			queue.addAll(newTransactions);
        		}
        	}
        	
        	if (find) {
        		break;
        	}
        	wordList.removeAll(levelWord); // delete level words
        }
        
        return res;
    }
    
    private List<List<String>> bfsHelper (List<String> currentTransaction, String endWord, Set<String> wordList, Set<String> transitionWords) {
    	List<List<String>> res = new ArrayList<>();

    	
    	String originalWord = currentTransaction.get(currentTransaction.size() - 1);
    	wordList.remove(originalWord);
    	char[] wordChars = originalWord.toCharArray();
    	
    	for (int i = 0; i < wordChars.length; i++) {
    		char originalChar = wordChars[i];
    		
    		for (char c = 'a'; c <= 'z'; c++) {
    			wordChars[i] = c;
    			String newWord = String.valueOf(wordChars);
    			
    			if (wordList.contains(newWord)) {
    				transitionWords.add(newWord);
    				currentTransaction.add(newWord);
    				res.add(new ArrayList<>(currentTransaction));
    				currentTransaction.remove(currentTransaction.size() - 1); // back track
    			}
    			
    			if (newWord.equals(endWord)) {
    				currentTransaction.add(newWord);
    				res.clear();
    				res.add(new ArrayList<>(currentTransaction));
    				return res;
    			}
    		}
    		wordChars[i] = originalChar; // back track
    	}
    			return res;
    	
    }
}