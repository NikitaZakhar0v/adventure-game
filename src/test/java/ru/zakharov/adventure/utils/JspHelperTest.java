package ru.zakharov.adventure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JspHelperTest {
    @Test
    void getPath() {
        Assertions.assertEquals("/WEB-INF/jsp/index.jsp", JspHelper.getPath("index"));
    }
}