package org.Board;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[65]; // Size of BigInteger
        isEndOfWord = false;
    }
}
