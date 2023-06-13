package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.domain.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;
    private final LoginService loginService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member){
        return "member/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "member/addMemberForm";
        }

        memberRepository.save(member);

        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/test")
    public String test(@RequestBody Member test){
        log.info("test member = {}",test);
        return "ok";
    }
}
