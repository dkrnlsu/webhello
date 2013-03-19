package myboard.controller;

import myboard.repository.BoardDbRepository;
import myboard.repository.BoardRepository;

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
public class DeleteServlet extends HttpServlet{

    BoardRepository boardRepository = BoardDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 체크하여 비로그인시 로그인창으로 이동
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogin") == null) {
            response.sendRedirect("/board/loginForm");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String pw = request.getParameter("pw");
            boardRepository.deleteBoard(id, pw);

            //list로 이동
            response.sendRedirect("/board/list");
        }
    }
}
