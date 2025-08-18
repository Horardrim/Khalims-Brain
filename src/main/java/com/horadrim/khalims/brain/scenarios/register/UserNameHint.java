package com.horadrim.khalims.brain.scenarios.register;

import java.util.List;

import org.springframework.stereotype.Service;

import com.horadrim.khalims.brain.dao.entity.TestUser;
import com.horadrim.khalims.brain.dao.repo.TestUserRepository;
import com.horadrim.khalims.brain.utils.Trie;

import jakarta.annotation.PostConstruct;

@Service
public class UserNameHint {
    
    private final TestUserRepository testUserRepository;

    private final Trie userNameTrie;

    public UserNameHint(TestUserRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
        userNameTrie = new Trie();
    }

    @PostConstruct
    void loadUserNames() {
        List<TestUser> users = testUserRepository.findAll();
        for(TestUser u : users) {
            userNameTrie.insert(u.getUsername());
        }
    }

    public List<String> matchUserNamesWithPrefix(String prefix) {
        return userNameTrie.matchUserNamesWithPrefix(prefix);
    }
}
