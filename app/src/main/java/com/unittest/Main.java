package com.unittest;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, Exception{
        Option option = new Option();
        MenuService menu = new MenuService();
        FileIOService fileIOService = new FileIOService();
        UserInput userInput = new UserInput();
        
        List<String> currentFile = new ArrayList<String>();
        
        String fileName = "";
        String filePath = "C:/Users/Rocky/Desktop/unit-test/app/src/main/resources/";
        try {
            fileName = args[0];    
        }catch(Exception e){fileName = "noFile";}
        
        String fileDirectory = filePath + fileName;
        
        File tempFile = new File(fileDirectory);
        
        boolean exist = tempFile.exists();
        
        if (!exist){
            System.out.println("No file selected!");
            int row = userInput.inputRow();
            int column = userInput.inputColumn();
            currentFile = menu.reset(row, column);
            option.setCurrentFile(currentFile);
            option.displayOptions();
        }else {
            option.setFileName(fileName);
            currentFile = fileIOService.readFile(filePath, fileName);
            option.setCurrentFile(currentFile);
            option.displayOptions(); 
        }
    }
}