package ua.epam.project4.controller.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by danik on 03.02.2016.
 */
public class LoginFilter implements Filter {

    public static final String USER = "user";
    public static final String DEFAULT_PAGE = "index.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        if(session != null && session.getAttribute(USER) != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendRedirect(DEFAULT_PAGE);
        }
    }

    @Override
    public void destroy() {

    }
}
