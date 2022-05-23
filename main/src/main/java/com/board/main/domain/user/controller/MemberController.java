package com.board.main.domain.user.controller;

import com.board.main.domain.user.dto.LoginFormDto;
import com.board.main.domain.user.dto.MemberDto;
import com.board.main.domain.user.dto.PasswordChangeFormDto;
import com.board.main.domain.user.dto.SignupForm;
import com.board.main.domain.user.service.MemberService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class MemberController {


    private final MemberService memberService;    //memberService는 단 하나만 있어도 된다. Autowired를 생성자로 호출해서 자바에서 하나만 관리하게끔

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String createSignupForm(@ModelAttribute("signupform") SignupForm signupform) {
        return "users/signupForm";
    }


    @PostMapping("/signup")
    public String creat(@ModelAttribute("signupform") @Valid SignupForm signupform,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/users/signupForm";
        }

        try {
            memberService.join(signupform);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            bindingResult.reject("signupFail", "이미 등록된 사용자입니다.");

            return "/users/signupForm";
        }

        return "redirect:/";
    }

    @GetMapping("/view")
    public String List(Model model){
        List<MemberDto> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "users/viewAllMember";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginFormDto loginForm) {
        return "users/loginForm";
    }

    @GetMapping("/detail")
    public String showInformaion(Model model, Principal principal) throws Exception {

        Optional<MemberDto> member = memberService.findMember(Long.parseLong(principal.getName()));
        if (!member.isPresent()) {
            System.out.println("유효하지 않은 회원입니다.");
            return "redirect:/";
        }
        model.addAttribute("member", member);
        return "users/view";
    }

    @GetMapping("/modify")
    public String createModifyForm(
            @ModelAttribute("passwordForm") PasswordChangeFormDto passwordChangeFormDto) {
        return "users/modify";
    }

    @PutMapping("/modify")
    public String updateUserPassword(
            @ModelAttribute("passwordForm") @Valid PasswordChangeFormDto passwordChangeFormDto,
            BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "/users/modify";
        }

        if (!passwordChangeFormDto.getNewPassword()
                .equals(passwordChangeFormDto.getReNewPassword())) {  // 1. 새로운 비밀번호의 재입력값이 입력한 새 비밀번호와 일치 검사
            bindingResult.reject("passwordFormMismatch", "새로 입력한 비밀번호가 서로 일치하지 않습니다.");
            return "/users//modify";
        }

        if (passwordChangeFormDto.getNewPassword()
                .equals(passwordChangeFormDto.getOldPassword())) { // 2. 변경할 비밀번호가 새 비밀번호과 같은지 검사
            bindingResult.reject("duplicatePassword", "새로 입력할 비밀번호를 다르게 입력해주세요.");
            return "/users/modify";
        }

        try {
            memberService.changePassword(passwordChangeFormDto, principal);
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("passwordError", e.getMessage());
            return "/users/modify";
        }
        return "redirect:/";
    }

}
