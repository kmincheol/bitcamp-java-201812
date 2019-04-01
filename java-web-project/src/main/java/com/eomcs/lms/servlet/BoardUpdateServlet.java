package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/update")
@SuppressWarnings("serial")
public class BoardUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setContents(request.getParameter("contents"));

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<html><head>" + "<title>게시물 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>" + "</head>");
    out.println("<body><h1>게시물 변경</h1>");

    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.
    BoardService boardService = ServerApp.iocContainer.getBean(BoardService.class);
    if (boardService.update(board) == 0) {
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }

    out.println("</body></html>");
  }
}

