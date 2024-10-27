package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //factoryBean을 통해 bean을 등록(생성)
    //GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    //bean을 등록하는 방법은 크게 보면 두가지 정도
    //- 직접 spring bean을 등록하는 방법(xml)
    //- factoryMethod를 통해서 등록하는 방법 (어노테이션, AppConfig)

    @Test
    @DisplayName("빈 설정 메타정보 확인") //BeanDefinition 확인
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName + "beanDefinition = " + beanDefinition);
            }
        }
    }
}
