package com.horadrim.khalims.brain.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Trie implements Serializable {

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.next_.computeIfAbsent(ch, c -> new TrieNode());
        }
        cur.isEndOfStr_ = true;
    }

    public List<String> matchUserNamesWithPrefix(String prefix) {
        if (Objects.isNull(prefix) || prefix.isEmpty()) {
            return List.of();
        }

        List<String> matchedUserNames = new ArrayList<>();
        TrieNode curNode = root;

        // 依照prefix中的字符来寻找是否存在TrieNode，没有的话说明prefix并不能匹配到已经存在的用户名
        for (char c : prefix.toCharArray()) {
            curNode = curNode.next_.get(c);
            if (curNode == null) {
                return matchedUserNames;
            }
        }

        dfs(curNode, new StringBuilder(prefix), matchedUserNames);

        return matchedUserNames;
    }

    private void dfs(TrieNode n, StringBuilder path, List<String> matchedUserNames) {
        if (n.isEndOfStr_) {
            matchedUserNames.add(path.toString());
        }

        for (Map.Entry<Character, TrieNode> e : n.next_.entrySet()) {
            path.append(e.getKey());
            dfs(e.getValue(), path, matchedUserNames);
            // 删除最后一个字符来匹配前缀树的下一个节点
            path.deleteCharAt(path.length() - 1);
        }
    }

    private static class TrieNode {

        @JsonProperty("end_of_str")
        private boolean isEndOfStr_;

        @JsonProperty("next")
        private Map<Character, TrieNode> next_ = new HashMap<>();
    }
}
