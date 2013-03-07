package myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class LogoutServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션정보 소멸
        HttpSession session = request.getSession();
        System.out.println(session);
        session.invalidate();
        response.sendRedirect("/board/list");
    }
}
