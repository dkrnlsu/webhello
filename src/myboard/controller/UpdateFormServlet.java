package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class UpdateFormServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 로그인 체크하여 비로그인시 로그인창으로 이동
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogin") == null) {
            response.sendRedirect("/board/loginForm");
        } else {
            //1. model에서 데이터 조회
            Board board = boardRepository.getBoard(Integer.parseInt((request.getParameter("id"))));

            //2. request에 데이터 셋팅
            if (board == null) {
                response.sendRedirect("/board/list");
            } else {
                request.setAttribute("id",board.getId());
                request.setAttribute("title",board.getTitle());
                request.setAttribute("content",board.getContent());
                request.setAttribute("writer",board.getWriter());
                request.setAttribute("pw",board.getPw());
            }
            //3. jsp찾아서 이동
            RequestDispatcher view = request.getRequestDispatcher("/board/updateForm.jsp");
            view.forward(request, response);
        }
    }
}
