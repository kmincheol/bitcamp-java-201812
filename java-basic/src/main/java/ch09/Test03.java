// 클래스 필드의 한계
package ch09;

public class Test03 {
  public static void main(String[] args) {

    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식1) 6 / 2 + 8
    
    //Calculator2의 result 변수는 오직 한 개만 존재한다.
    // 따라서 다음과 같이 두 개의 계산식을 동시에 수햏할 수
    Calculator2.plus(2); // 식1 계산 => 2
    Calculator2.plus(6); // 식2 계산 => 6
    Calculator2.multiple(3); // 식1 => 2 * 3 
    Calculator2.divide(2); // 식2 => 6 / 2
    Calculator2.minus(2); // 식1 => 2 * 3 - 2
    Calculator2.plus(8); // 식2 => 6 / 2 + 8
    Calculator2.plus(7); // 식1 => 2 * 3 - 2 + 7
    
    System.out.println(Calculator2.result);

    // 동시에 계산식을 수행하는 방법은 없을까?
    // Calculator2는 불가능 하다.,
    // 오히려 Calculator1 은 가능하다. 왜? 계산 결과를 호출하는 쪽에서 관리하기 때문에다.
  }
}