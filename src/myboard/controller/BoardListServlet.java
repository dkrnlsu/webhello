package myboard.controller;

import hello.ResultModel;
import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardListServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int loginCount = Integer.parseInt(request.getServletContext().getInitParameter("loginCount"));

        if (request.getServletContext().getAttribute("loginCount") == null) {
            request.getServletContext().setAttribute("loginCount", 0);
        }
        int loginCount = (Integer) request.getServletContext().getAttribute("loginCount");

        //1. model에서 데이터 조회
        List<Board> boards = boardRepository.getBoards();

        //2. request에 데이터 셋팅
        request.setAttribute("boards",boards);
        request.setAttribute("loginCount",loginCount);

        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardList.jsp");
        view.forward(request, response);
    }
}
