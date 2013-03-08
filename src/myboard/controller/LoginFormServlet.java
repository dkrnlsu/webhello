package myboard.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class LoginFormServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿠키중 ID 저장 값이 있다면 넣어주기
        Cookie[] cookies = request.getCookies();
        String idSave = "";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("idsave")) {
                idSave = cookie.getValue();
            }
        }
        request.setAttribute("idSave", idSave);
        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/loginForm.jsp");
        view.forward(request, response);
    }
}
