package com.unittest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;

import java.util.*;
import java.io.*;

public class ValidatorTest {
    Validator validator = new Validator();
    
    String resultStr;
    int resultInt;
    boolean isTrue;
    
    @Test
    public void validateStrLengthTest() {
        resultStr = validator.validateStrLength("asd");
        assertEquals("asd", resultStr);
        
        String str = "asdasd";
        if(str.length() > 3 ) {
            resultStr = "zxc";
            assertNotEquals(str, resultStr);
        }else {
            resultStr = validator.validateStrLength("asd");
            assertNotEquals(str, resultStr);
        }
        
        
        str = "";
        if(str.length() < 1 ) {
            resultStr = "zxc";
        }else {
            resultStr = validator.validateStrLength("");    
        }
        assertNotEquals(str, resultStr);
    }
    
    @Test
    public void createAsciiKeyTest() {
        resultStr = validator.createAsciiKey();
        assertEquals(3, resultStr.length());
    }
    
    @Test
    public void checkIntegerInputTest() {
        int value = 3;
        int lowerLimit = 1;
        int upperLimit = 7;
        boolean resultBool;
        
        if(value < lowerLimit || value > upperLimit) {
            resultInt = 0;
            assertNotEquals(value, resultInt);
        }else {
            resultInt = validator.checkIntegerInput(value, lowerLimit, upperLimit);
            assertEquals(value, resultInt);
        }
        
        
        value = 12;
        lowerLimit = 1;
        upperLimit = 10;
        
        if(value < lowerLimit || value > upperLimit) {
            resultInt = 0;
        }else {
            resultInt = validator.checkIntegerInput(value, lowerLimit, upperLimit);
        }
        
        if(value == resultInt) {
            resultBool = true;
        }else { resultBool = false; }
        assertEquals(false, resultBool);
    }
}