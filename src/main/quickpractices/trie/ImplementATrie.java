package main.quickpractices.trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementATrie {
    private TrieNode root;

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd = false;

        private TrieNode() {
            this.children = new HashMap<>();
        }

        private TrieNode getChild(Character character) {
            return children.get(character);
        }

        private TrieNode insertChild(Character character) {
            TrieNode child = new TrieNode();
            children.put(character, child);
            return child;
        }
    }

    public ImplementATrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (current.getChild(character) != null) {
                current = current.getChild(character);
            } else {
                current = current.insertChild(character);
            }
        }
        current.isEnd = true;
    }

    private boolean traverseTree(String word, boolean checkEnd) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            current = current.getChild(character);
            if (current == null) {
                return false;
            }
        }
        return !checkEnd || current.isEnd;
    }

    public boolean search(String word) {
        return traverseTree(word, true);
    }

    public boolean startsWith(String prefix) {
        return traverseTree(prefix, false);
    }

    public static void main(String[] args) {
        var solution = new ImplementATrie();
        solution.insert("apple");
       solution.insert("app");
        System.out.println(solution.search("app"));
        System.out.println(1);
    }

}
