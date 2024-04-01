package com.example.thymeleaf;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(String name, String email, String message, Model model) {
        // 이메일 보내기
        messageService.sendEmail(email, "새로운 메시지가 도착했습니다.", message);

        // 성공 메시지
        model.addAttribute("successMessage", "메시지가 성공적으로 전송되었습니다.");
        return "index";
    }
}
