package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)//데이터 변경시 꼭 있어야 함
@RequiredArgsConstructor    //final 이 있는 필드만 가지곡 생성자를 만들어줌 : 생성자 주입 방식 생략 가능
public class MemberService {

//    @Autowired
//    private MemberRepository memberRepository;


    //setter 인젝션 -> 테스트 시 mock 주입 가능, 단점 : set으로 변경 가능
//    private MemberRepository memberRepository;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //1. 생성자 인젝션
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //2. 생성자 인젝션
    //@RequiredArgsConstructor 선언으로  final로 필드에 선언 만으로 주입
    private final MemberRepository memberRepository;


    /*
     *회원가입
     */
    @Transactional//기본적으로 false
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //중복확인
    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());   //데이터 베이스에  unique 제약 조건 주는것이 좋음
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //상세 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
