package com.horadrim.khalims.brain.scenarios.register;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horadrim.khalims.brain.dao.entity.TestUser;
import com.horadrim.khalims.brain.dao.repo.TestUserRepository;
import com.horadrim.khalims.brain.utils.Trie;

import jakarta.annotation.PostConstruct;

@Service
public class UserNameHint {
    
    private final TestUserRepository testUserRepository_;

    private Trie userNameTrie_;

    public UserNameHint(TestUserRepository testUserRepository_) {
        this.testUserRepository_ = testUserRepository_;
        userNameTrie_ = new Trie();
    }

    @PostConstruct
    void loadUserNamesFromDB() {
        List<TestUser> users = testUserRepository_.findAll();
        for(TestUser u : users) {
            userNameTrie_.insert(u.getUsername());
        }
    }

    public List<String> matchUserNamesWithPrefix(String prefix) {
        return userNameTrie_.matchUserNamesWithPrefix(prefix);
    }

    public void persistTrieToSnapshot() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(Paths.get("user_name_trie.json").toFile(), userNameTrie_);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTrieFromSnapshot() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userNameTrie_ = objectMapper.readValue(Paths.get("user_name_trie.json").toFile(), Trie.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}