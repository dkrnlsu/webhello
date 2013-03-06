package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class UpdateServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //데이터 저장
        Board board = new Board();
        board.setId(Integer.parseInt(request.getParameter("id")));
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setWriter(request.getParameter("writer"));
        board.setPw(request.getParameter("pw"));
        boardRepository.updateBoard(board);

        //list로 이동
        response.sendRedirect("/board/list");
    }
}
