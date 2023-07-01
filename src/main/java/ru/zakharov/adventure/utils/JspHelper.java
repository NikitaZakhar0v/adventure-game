package ru.zakharov.adventure.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class JspHelper {
    private final String JSP_FORMAT = "/WEB-INF/jsp/%s.jsp";

    public String getPath(String jspName){
        return String.format(JSP_FORMAT, jspName);
    }
}
