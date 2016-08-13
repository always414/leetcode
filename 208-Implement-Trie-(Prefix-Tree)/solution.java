import java.util.*;

class TrieNode {
	Map<Character, TrieNode> children;
	// Initialize your data structure here.
	public TrieNode() {
		children = new HashMap<>();
	}
	
	public void buildPrefixTree(String word) {
		if (word.length() == 0) {
			children.put('#', null);
		} else {
			Character c = word.charAt(0);
			children.putIfAbsent(c, new TrieNode());
			TrieNode subTrie = children.get(c);
			subTrie.buildPrefixTree(word.substring(1));
		}
	}
	
	public boolean searchWord(String word) {
		if (word.length() == 0) {
			return children.containsKey('#');
		}
		Character c = word.charAt(0);
		if (!children.containsKey(c)) return false;
		return children.get(c).searchWord(word.substring(1));
	}
	
	public boolean searchPrefix(String prefix) {
		if (prefix.length() == 0) return true;
		Character c = prefix.charAt(0);
		if (!children.containsKey(c)) return false;
		return children.get(c).searchPrefix(prefix.substring(1));
	}
	
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		root.buildPrefixTree(word);
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		return root.searchWord(word);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return root.searchPrefix(prefix);
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");