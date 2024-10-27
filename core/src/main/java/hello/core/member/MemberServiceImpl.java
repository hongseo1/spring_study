package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //사실 MemberServiceImpl은 추상과 구체화 둘다 의존하고 있으  므로 DIP를 위반 하고 있다.
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.claas)
    //자동으로 의존관계 주입 (@Component 사용시 필요)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //DIP를 위반 하지 않도록 수정

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
