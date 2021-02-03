package com.unittest;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import org.apache.commons.lang3.*;
public class MenuService {
	
	public void search(Map<String, String> currentFileMap, String strToSearch) {
        boolean matchOccur = false;
        
		System.out.println("KEY	VALUE	OCCURENCE");
        
        Pattern pattern = Pattern.compile(strToSearch);
		
		for(HashMap.Entry<String, String> entry : currentFileMap.entrySet()){
            int count = 0;
            Matcher matcher = pattern.matcher(entry.getValue().toString());
            
            while(matcher.find()) { count++; }
            
            if(count !=0) {
                System.out.println(entry.getKey() + "\t" + entry.getValue() + "\t     " + count);
                matchOccur = true;
            }
        }
        
        if(matchOccur == false) {
            System.out.println("No matche/s found!");
        }
	}
	
	public List<String> edit(List<String> currentFile, int selectedRow, int selectedColumn, String newValue) {
		String lineToEdit = "";
		boolean isNotValid = true;
		
		lineToEdit = currentFile.get(selectedRow-1);
		String[] lineKeyValue = lineToEdit.split("\t");
        
		String[] keyValue = lineKeyValue[selectedColumn-1].split(":", 2);
		keyValue[1] = newValue;
		
		lineKeyValue[selectedColumn-1] = keyValue[0] + ":" + keyValue[1];
		lineToEdit = "";
		for (int i = 0; i < lineKeyValue.length; i++) {
			lineToEdit += lineKeyValue[i] + "\t";
		}
		
		currentFile.set(selectedRow-1, lineToEdit.trim());
        
        return currentFile;
	}
	
	public void print(List<String> currentFile) {
		for(int i = 0; i < currentFile.size(); i++) {
            System.out.println(currentFile.get(i));
        }
	}
	
	public List<String> addRow(List<String> currentFile) {
        Validator validator = new Validator();
        
		String lineToAdd = "";
		String asciiValue = "";
		String asciiKey = "";
		String[] elementsInFirstRow = currentFile.get(0).split("\t");
        int numElements = elementsInFirstRow.length;
		
        for (int i = 0; i < numElements; i++) {
            asciiKey = validator.createAsciiKey();
            asciiValue = RandomStringUtils.randomAscii(3);

            lineToAdd += asciiKey + ":" + asciiValue + "\t";
        }
        currentFile.add(lineToAdd);
        
		return currentFile;
	}
	
	public List<String> sortRow(List<String> currentFile, int rowToSort) {
		String[] rowElements = currentFile.get(rowToSort-1).split("\t");
		String sortedRow = "";
		
		Arrays.sort(rowElements);
		
		for (int i = 0; i < rowElements.length; i++) {
			sortedRow += rowElements[i] + "\t";
		}
		
		currentFile.set(rowToSort-1, sortedRow.trim());
        
        return currentFile;
	}

	public List<String> reset(int row, int column) {
        Validator validator = new Validator();
		
		String line = "";
		String asciiValue = "";
		String asciiKey = "";
		boolean notUnique = true;
		
		List<String> currentFile = new ArrayList<>();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				asciiKey = validator.createAsciiKey();
				asciiValue = RandomStringUtils.randomAscii(3);
				
				line += asciiKey + ":" + asciiValue + "\t";
			}
			currentFile.add(line);
			line = "";
		}
		return currentFile;
	}
    
	public void exit() {
		System.out.println("The System has Exited! Thank you");
		System.exit(1);
	}
}