// java.sql.Result 객체 - 서버에서 select의 결과를 가져오기 III
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test09 {
  public static void main(String[] args) {
    try (Connection con = DriverManager
        .getConnection("jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS 연결됨");

      // Connection 객체를 통해 SQL을 DBMS에 전달할 때 사용할 도구를 얻는다.
      // => java.sql.Statement 구현체이다.
      try (Statement stmt = con.createStatement()) {

        try(ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc")){

          while (rs.next()) {
            // 레코드에서 컬럼 값을 꺼낼 때 컬럼의 타입에 상관없이 무조건 문자열로 받을 수 있다.
            //
            System.out.printf("%s, %s, %s, %s, %s\n", 
                rs.getString("board_id"),
                rs.getString("title"),
                rs.getString("contents"),
                rs.getString("created_date"),
                rs.getString("view_count"));
          }
        }
        System.out.println("입력 성공");

      }
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }
}


