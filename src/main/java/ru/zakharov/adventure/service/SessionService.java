package ru.zakharov.adventure.service;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@UtilityClass
public final class SessionService {
    private final String USER_NAME = "username";
    private final String USER = "user";
    private final String EXIT = "exit";

    @SneakyThrows
    public void getSession(HttpServletRequest request) {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        var userAttribute = (User) session.getAttribute(USER);
        if (userAttribute == null) {
            putNewUserToSession(request, session);
        }
    }

    private void putNewUserToSession(HttpServletRequest request, HttpSession session) {
        User user = UserService.createNewUser(
                session.getId(),
                request.getParameter(USER_NAME),
                getClientIpAddress(request));
        session.setAttribute(USER, user);
    }

    public static void updateSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        UserService.updateStatistics(user);
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");

        String unknown = "unknown";

        if (ipAddress == null || ipAddress.isEmpty() || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }

    public static void validDisconnect(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        var parameter = servletRequest.getParameter(EXIT);
        if(EXIT.equals(parameter)){
            disconnectSession(servletRequest, servletResponse);
        }
    }
    @SneakyThrows
    private void disconnectSession(HttpServletRequest request, HttpServletResponse response) {
        UserService.delete((User) request.getSession().getAttribute(USER));
        request.getSession().invalidate();
        response.sendRedirect("/");
    }
}
