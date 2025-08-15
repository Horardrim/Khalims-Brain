package com.horadrim.khalims.brain.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 简单模拟登录处理
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        if ("admin".equals(username) && "123".equals(password)) {
            model.addAttribute("msg", "登录成功");
            return "login";   // templates/success.html
        }
        model.addAttribute("error", "账号或密码错误");
        return "login";
    }
}
