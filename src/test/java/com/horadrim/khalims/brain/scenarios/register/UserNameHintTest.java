package com.horadrim.khalims.brain.scenarios.register;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.horadrim.khalims.brain.dao.entity.TestUser;
import com.horadrim.khalims.brain.dao.repo.TestUserRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
    UserNameHint.class,
    TestUserRepository.class
})
@Slf4j
public class UserNameHintTest {
    @MockBean
    private TestUserRepository testUserRepository_;

    @Autowired
    private UserNameHint userNameHint_;

    @BeforeEach
    void setup() {
        when(testUserRepository_.findAll())
            .thenReturn(List.of(new TestUser(1, "TalRasha", "test"),
                                new TestUser(2, "Tallaaha", "testb")));
    }

    @Test
    public void test() {
        userNameHint_.loadUserNamesFromDB();
        userNameHint_.persistTrieToSnapshot();
        Assertions.assertTrue(userNameHint_.matchUserNamesWithPrefix("Tal").size() == 2);

        UserNameHint t = new UserNameHint(testUserRepository_);
        t.loadTrieFromSnapshot();
        Assertions.assertTrue(t.matchUserNamesWithPrefix("Tal").size() == 2);
    }
}
