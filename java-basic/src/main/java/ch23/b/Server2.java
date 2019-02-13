// 데이터 주고 받기 - 에코(echo) 서버 만들기
package ch23.b;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("클라이언트의 연결을 기다림!");

      try (Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream())) {

        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음");
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");

        System.out.println("데이터 보내기 전에 잠깐!");
        keyboard.nextLine(); // 사용자가 콘솔 창에서 엔터를 칠 때까지 리턴하지 않는다.

        String request = in.nextLine(); // blocking 모드로 작동한다.
        System.out.println(request);

        System.out.println("데이터 보내기 전에 잠깐!");
        keyboard.nextLine(); // 사용자가 콘솔 창에서 엔터를 칠 때까지 리턴하지 않는다.

        out.write("**" + request + "**");
        out.flush();
        System.out.println("클라이언트에게 데이터를 보냈음.");

      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}