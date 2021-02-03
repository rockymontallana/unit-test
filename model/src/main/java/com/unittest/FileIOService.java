package com.unittest;
import java.util.*;
import java.io.*;
public class FileIOService {

    public List<String> readFile(String filePath, String fileName) throws IOException{
        List<String> currentFile = new ArrayList<String>();
        String fileDirectory = filePath + fileName;
        Scanner fileInput = new Scanner(new File(fileDirectory));
        
        while (fileInput.hasNextLine()) {
			currentFile.add(fileInput.nextLine());
        }
        fileInput.close();
        
        for (int i = 0; i < currentFile.size(); i++) {
			if (currentFile.get(i).trim().isEmpty()) {
				currentFile.remove(i);
			}
		}
		
		return currentFile;
    }
	
	public void writeFile(List<String> currentFile, String filePath, String fileName) throws IOException{
        String fileDirectory = filePath + fileName;
		FileWriter writer  = new FileWriter(fileDirectory);
        
        String newFileContent = "";
        
		for (int i = 0; i < currentFile.size(); i++) {
            if(i == currentFile.size() - 1){
                newFileContent += currentFile.get(i);
            }else{
                newFileContent += currentFile.get(i) + "\n";
            } 
        }
        
		writer.write(newFileContent);
		writer.close();
	}
	
	public Map<String, String> createMap(List<String> currentFile) throws IOException{
		Map<String, String> currentFileMap = new LinkedHashMap<>();
		
		for (int i = 0; i < currentFile.size(); i++) {
			String[] listLine = currentFile.get(i).split("\t");
			
			for (int j = 0; j < listLine.length; j++) {
				String[] keyValue = listLine[j].split(":", 2);
				
				if (keyValue.length >= 2) {
					currentFileMap.put(keyValue[0], keyValue[1]);
				}
			}
		}
		
		return currentFileMap;
	}
}