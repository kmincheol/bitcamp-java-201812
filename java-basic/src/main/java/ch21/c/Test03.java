// 애플리케이션 예외의 종류 : Exception 계열의 예외 처리 II
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test03 {
  public static void main(String[] args)
      // throws ClassNotFoundException { // 정확하게 예외 클래스를 지정해도 되고
      throws ClassNotFoundException, 
      NoSuchMethodException, // 이 메서드에서 발생하는 예외의 목록을 지정한다.
      InstantiationException, // 만약 메서드를 실행하는 중에 이런 예외가 발생한다면
      IllegalAccessException, // 즉시 이 메서드의 실행을 멈추고
      IllegalArgumentException, // 이 메서드를 호출한 쪽에 예외 정보를 보고한다.
      InvocationTargetException { // main()의 호출자? JVM이다.
    
    // Exception 계열의 예외 방법
    // 1) try ~ catch로 예외 받기
    //    try {
    //          예외 발생 코드
    //      } catch (예외 파라미터) {
    //          예외처리 코드
    //        }
    // 2) 호출차에게 예외 처리를 떠넘기기
    //    void 메서드() throws 예외클래스명, 예외클래스명, ... {
    //          예외가 발생할 수 있는 코드
    //      }
    //

    // '방법2' 적용
    // => 메서드 선언부에 throws 절 추가하기
    // => 이 방식을 사용해야 하는 경우?
    //    이런 예외를 한곳에서 처리하고 싶을 때 이 방식을 사용한다.
    // => 호출자가 처리하도록 보고하라는 의미

    Scanner keyboard = new Scanner(System.in);
    Class<?> clazz = Class.forName("ch21.c.PlusCommand");
    Constructor<?> constructor = clazz.getConstructor(Scanner.class);
    Command command = (Command) constructor.newInstance(new Scanner(System.in));
    command.execute();
  }
}
