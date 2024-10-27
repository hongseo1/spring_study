package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member", //member만 component대상이 됨
        //basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
        //basePackages, basePackageClasses 설정하지 않을 시 기본값은 @ComponentScan 어노테이션이 붙은 package hello.core 여기서터 포함 하위 패키지를 전부 탐색한다. 즉,@ComponentScan 어노테이션이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만, 기존 예졔 코드를 최대한 남기고 유지하기 위해서 제외함
        //@ComponentScan은 @Component 어노테이션이 붙은 클래ㅐ스를 스캔해서 스프링 빈으로 등록한다.
)
public class AutoAppConfig {
    /*
    @Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    */
}