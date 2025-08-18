package com.horadrim.khalims.brain.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horadrim.khalims.brain.scenarios.register.UserNameHint;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsernameInputCaretControlller {

    record InputPayload(String text) {}

    final private UserNameHint userNameHint;

    @PostMapping("/caret")
    @CrossOrigin           // 本地调试允许跨域
    public List<String> receive(@RequestBody InputPayload payload) {
        System.out.println("input content = " + payload.text());
        return userNameHint.matchUserNamesWithPrefix(payload.text());
    }
}
