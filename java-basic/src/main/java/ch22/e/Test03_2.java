// 인스턴스 읽기 - 컬렉션 API사용
package ch22.e;

import java.io.FileInputStream;
import java.util.ArrayList;
import ch19.e.Array;
import ch22.c.BufferedInputStream;
import ch22.c.DataInputStream;

public class Test03_2 {
  public static void main(String[] args) {

    // Score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    // => java.io.BUfferedInputStream 클래스를 사용하라.
    // => java.io.DataInputStream 클래스를 사용하라
    //
    
    ArrayList<Score> students = new ArrayList<>();
    
    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라
    // => 홍길동, 100, 100, 100, 300, 100
    
    try (DataInputStream in = 
        new DataInputStream(
            new BufferedInputStream(
                new FileInputStream("score.data")))) {

      int len = in.readInt();

      for (int i = 0; i < len; i++) {
        Score s = new Score();
        s.setName(in.readUTF());
        s.setKor(in.readInt());
        s.setEng(in.readInt());
        s.setMath(in.readInt());
        students.add(s);
      }
      
      for (Score s : students) {
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s.getName(), s.getKor(), s.getEng(), 
            s.getMath(), s.getSum(), s.getAver());
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("읽기완료");
  }
}

