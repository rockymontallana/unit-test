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

public class MenuServiceTest {
    MenuService ms = new MenuService();
    
    List<String> currentFile = new ArrayList<>();
    List<String> resultFile = new ArrayList<>();
    
    @Before
    public void setCurrentFile() {
        currentFile.add("FTV:HQ.	P3Z:JsZ	DY5:T,9	AGM:<.|	GJG:0!w");
        currentFile.add("EAA:+fK	UY9:s0 	ASD:Mvf	RQ4:w4E	G35:@XW");
        currentFile.add("64Z:&(0	HPT:PBe	DMX:*d4	H2H:*aW	1P8:@;.");
    }
    
    @After
    public void clearResultFile() {
        resultFile.clear();
    }
    
    @Test
     public void editTest() {
         resultFile = ms.edit(currentFile, 1, 1, "ASD");
         assertEquals("FTV:ASD	P3Z:JsZ	DY5:T,9	AGM:<.|	GJG:0!w", resultFile.get(0));
         resultFile = ms.edit(currentFile, 3, 5, "AAA");
         assertEquals("64Z:&(0	HPT:PBe	DMX:*d4	H2H:*aW	1P8:AAA", resultFile.get(2));
     }
    
    @Test
    public void addRowTest() {
        resultFile = ms.addRow(currentFile);
        assertEquals(4, resultFile.size());
    }
    
    @Test
    public void sortRowTest() {
        resultFile = ms.sortRow(currentFile, 1);
        assertEquals("AGM:<.|\tDY5:T,9\tFTV:HQ.\tGJG:0!w\tP3Z:JsZ", resultFile.get(0));
        resultFile = ms.sortRow(currentFile, 3);
        assertEquals("1P8:@;.\t64Z:&(0\tDMX:*d4\tH2H:*aW\tHPT:PBe", resultFile.get(2));
    }
    
    @Test
    public void resetTest() {
        resultFile = ms.reset(5,5);
        assertEquals(5, resultFile.size());
        resultFile = ms.reset(3,2);
        assertEquals(3, resultFile.size());
    }
}