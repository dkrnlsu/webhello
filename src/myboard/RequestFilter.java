package myboard;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 13
 * Time: 오후 3:43
 * To change this template use File | Settings | File Templates.
 */
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
        HttpServletRequest httpRequeset = (HttpServletRequest) servletRequest;
        // 인코딩
        httpRequeset.setCharacterEncoding("utf-8");
        // 로그찍기
        System.out.println(httpRequeset.getRemoteAddr() + " : " + httpRequeset.getRequestURI());

        RequestWrapper requestWrapper = new RequestWrapper(httpRequeset);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
