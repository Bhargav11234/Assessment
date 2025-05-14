import java.util.*;

// sec 3 prefix tree 
class TrieNode {
    TrieNode[] children = new TrieNode[26]; 
    boolean isEndOfWord = false;
}

public class Trie {
    private final TrieNode root;
    public Trie() {       // con
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("apple"));   
        System.out.println(trie.search("app"));    
        System.out.println(trie.search("appl"));    
        System.out.println(trie.startsWith("app")); 
        System.out.println(trie.startsWith("apl")); 
    }
}
