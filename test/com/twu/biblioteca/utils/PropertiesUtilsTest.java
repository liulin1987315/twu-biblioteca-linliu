package com.twu.biblioteca.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PropertiesUtilsTest {

    @Test
    public void getBookProperty_KeyIsExistAsParam() {
        assertEquals("The key in the properties is exist.", "HeadFirstJava", PropertiesUtils.getBookProperty("HeadFirstJava.bookName"));
    }

}
