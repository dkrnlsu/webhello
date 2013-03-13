package myboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 13
 * Time: 오후 4:57
 * To change this template use File | Settings | File Templates.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public void setAttribute(String name, Object o) {
        System.out.println("setAttribute : " + name + ", value : " + o);
        super.setAttribute(name, o);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Object getAttribute(String name) {
        System.out.println("getAttribute : " + name);
        return super.getAttribute(name);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
