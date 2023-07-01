package ru.zakharov.adventure.servlet.filter;

import ru.zakharov.adventure.service.SessionService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/quiz")
public final class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionService.getSession((HttpServletRequest) servletRequest);
        SessionService.updateSession((HttpServletRequest) servletRequest);
        SessionService.validDisconnect((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
