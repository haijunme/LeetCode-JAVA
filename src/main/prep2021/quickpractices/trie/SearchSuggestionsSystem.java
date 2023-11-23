package main.prep2021.quickpractices.trie;

import java.util.*;

public class SearchSuggestionsSystem {
    //@formatter:off
    private static class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    //@formatter:on
    private TrieNode root;

    private void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            int charNumber = character - 'a';
            if (current.children[charNumber] == null) {
                current.children[charNumber] = new TrieNode();
            }
            current = current.children[charNumber];
        }
        current.isEnd = true;
    }

    private void recursiveDfs(TrieNode root, StringBuilder builder, List<String> answer) {
        if (root == null || answer.size() == 3) {
            return;
        }
        if (root.isEnd) {
            answer.add(builder.toString());
        }
        TrieNode[] children = root.children;
        for (int i = 0; i < 26; i++) {
            if (children[i] == null) {
                continue;
            }
            builder.append((char)('a' + i));
            recursiveDfs(children[i], builder, answer);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private List<String> getRelatedProductNames(TrieNode root, String prefix) {
        TrieNode current = root;
        // locate the node for the end of the prefix
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            int charNumber = character - 'a';
            if (current.children[charNumber] == null) {
                return Collections.emptyList();
            } else {
                current = current.children[charNumber];
            }
        }
        List<String> answer = new ArrayList<>();
        recursiveDfs(current, new StringBuilder(prefix), answer);
        return answer;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.root = new TrieNode();
        for (String product : products) {
            insertWord(this.root, product);
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            answer.add(getRelatedProductNames(root, prefix));
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new SearchSuggestionsSystem();
        System.out.println(solution.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},  "moudragon"));
    }
}
