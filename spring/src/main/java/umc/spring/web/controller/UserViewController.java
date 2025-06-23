package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.spring.service.userservice.UserCommandService;
import umc.spring.web.dto.UserRequestDTO;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    private final UserCommandService userCommandService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new UserRequestDTO.JoinDto());
        return "signup";
    }

    @PostMapping("/members/signup")
    public String join(
            @Valid @ModelAttribute("memberJoinDto") UserRequestDTO.JoinDto request,
            BindingResult bindingResult,
            Model model
    ) {
        System.out.println("🚀 컨트롤러 진입");
        if (bindingResult.hasErrors()) {
            System.out.println("❌ 바인딩 에러 발생: " + bindingResult);
            return "signup";
        }

        System.out.println("🔥 userCommandService 호출 전");
        userCommandService.join(request);
        return "redirect:/login";
    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
