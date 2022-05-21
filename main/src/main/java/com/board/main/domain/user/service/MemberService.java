package com.board.main.domain.user.service;

import com.board.main.domain.user.dto.MemberDto;
import com.board.main.domain.user.dto.PasswordChangeFormDto;
import com.board.main.domain.user.dto.SignupForm;
import com.board.main.domain.user.entity.Member;
import com.board.main.domain.user.repository.MemberRepository;
import com.board.main.domain.user.repository.MemoryMemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;



    private MemberDto of(Member member){
        return modelMapper.map(member,MemberDto.class);  //member entitiy를 member Dto로 변경
    }


    /**
     * 회원가입
     * @param member
     * @return string UserId;
     */
    public String join(SignupForm member) {

        duplicateIDCheck(member.getEmail());

        Member newMember = new Member();
        newMember.setEmail(member.getEmail());
        newMember.setUserName(member.getUserName());
        newMember.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(newMember);
        return member.getEmail();
    }

    /**
     * 중복 ID체크
     * @param memberId
     */
    private void duplicateIDCheck(String memberId) {
        memberRepository.findByEmail(memberId)
                .ifPresent(m -> {
            throw new IllegalStateException("이미 가입된 아이디 입니다."); //optional로 감싸서 다음과 같은 문법 사용가능.
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<MemberDto> findMembers() {
        List<Member>  membersList= memberRepository.findAll();

        List<MemberDto> memberDtoList = membersList.stream().map(q -> of(q)).collect(Collectors.toList());
        return memberDtoList;
    }

    /**
     * 특정 id값을 가지는 회원정보 조회
     * @param id
     * @return
     */
    public Optional<MemberDto> findMember(Long id){

        Optional<Member> memberById =  memberRepository.findById(id);
        Optional<MemberDto> memberDtoById = memberById.map(q -> of(q));
        return memberDtoById;

    }

    public void changePassword(PasswordChangeFormDto passwordChangeFormDto ,Principal principal)
            throws Exception {

        Optional<Member> member = memberRepository.findById(Long.parseLong(principal.getName()));

        if(!member.isPresent()) {
            throw new Exception("유효하지 않은 사용자 입니다.");
        }

        String oldPassword = member.get().getPassword(); //기존의 비밀번호

        if (passwordEncoder.matches(passwordChangeFormDto.getNewPassword(),
                oldPassword)) {   // 3. 기존의 입력 비밀번호가 적합한지 검사
            throw new Exception("현재 비밀번호 값이 일치하지 않습니다.");
        }

        member.get().setPassword(passwordEncoder.encode(passwordChangeFormDto.getNewPassword()));

       // memberRepository.save(member.get());

    }

}
