// 생성자 호출
package ch29.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("ch29/c/application-context-02.xml");

    System.out.println("----------------------------------------");

    
    System.out.println(iocContainer.getBean("c4"));
    
    System.out.println(iocContainer.getBean("c5"));
    
  }
}


