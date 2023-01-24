package org.Board;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String piece) {
        TrieNode node = root;
        for (int i = 0; i < piece.length(); i++) {
            int index = piece.charAt(i) - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String piece) {
        TrieNode node = root;
        for (int i = 0; i < piece.length(); i++) {
            int index = piece.charAt(i) - '0';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return (node != null && node.isEndOfWord);
    }
}
