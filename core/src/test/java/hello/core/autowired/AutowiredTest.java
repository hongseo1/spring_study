package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); //스프링 빈으로 등록
    }

    static class TestBean {
        @Autowired(required = false) //required = false: 의존 관계가 없으면 메서드 자체가 호출 X
        public void setNoBean1(Member noBean1) {//스프링 컨테이너에 아무것도 등록 되어있지 않은 거 아무거나 테스트 용도
            System.out.println("noBean1 = " + noBean1);

        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {//@Nullable: 자동 주입할 대상이 없으면 null이 입력.
            System.out.println("noBean2 = " + noBean2);

        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {//Optional<>: 자동 주입할 대상이 없으면 Optional.empty 입력.
            System.out.println("noBean3 = " + noBean3);

        }
    }
}
