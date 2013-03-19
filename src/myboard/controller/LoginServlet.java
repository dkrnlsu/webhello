package myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class LoginServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자 로그인 정부
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String idsave = request.getParameter("idsave");
        // 디폴트 로그인 정보
        String defaultId = getServletConfig().getInitParameter("defaultId");
        String defaultPassword = getServletConfig().getInitParameter("defaultPassword");

        // 사용자 정보와 디폴트 로그인 정보가 일치하는 경우 isLogin 세션 생성
        if (id.equals(defaultId) && password.equals(defaultPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);

            //접속자수 추가
            if (request.getServletContext().getAttribute("loginCount") == null) {
                request.getServletContext().setAttribute("loginCount", 1);
            } else {
                request.getServletContext().setAttribute("loginCount", ((Integer) request.getServletContext().getAttribute("loginCount")) + 1);
            }

            // ID 저장 체크가 안된 경우
            if (idsave == null) {
                // 기존 저장된 쿠키값이 있다면 제거
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie: cookies) {
                    if (cookie.getName().equals("idsave")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            // ID 저장 체크된 경우 - 해당 쿠키 저장
            } else {
                Cookie cookie = new Cookie("idsave", id);
                // 30일 유지
                cookie.setMaxAge(86400 * 30);
                response.addCookie(cookie);

            }
            response.sendRedirect("/board/list");
        // 사용자 정보와 디폴트 로그인 정보가 불일치하는 경우 다시 로그인폼으로 이동
        } else {
            response.sendRedirect("/board/loginForm");
        }
    }
}
