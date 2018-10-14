package pro.buildmysoftware;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Object loggedAttr = httpRequest.getSession().getAttribute("logged");
        if (Boolean.TRUE.equals(loggedAttr)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("../login.jsp");
        }
        
/*TEN KOD ROBI TO SAMO!!!*/
        /*Boolean logged = Optional.ofNullable(httpRequest.getSession().getAttribute("logged")).map(Boolean.class::cast).orElse(false);

        if (logged) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("../login.jsp");
        }*/
    }
}
