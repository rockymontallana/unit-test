package com.unittest;
import java.util.*;
import java.io.*;
public class Option {
    private String fileName;
    private final String filePath = "C:/Users/Rocky/Desktop/unit-test/app/src/main/resources/";
    
    private List<String> currentFile = new ArrayList<>();
    private Map<String, String> currentFileMap = new LinkedHashMap<>();
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setCurrentFile(List<String> currentFile) {
        this.currentFile = currentFile;
    }
    
    public void optionImp(int option) throws IOException, Exception{
        MenuService menu = new MenuService();
        FileIOService fileIOService = new FileIOService();
        UserInput userInput = new UserInput();
        
        switch (option) {

		case 1:
            currentFileMap = fileIOService.createMap(currentFile);
            String strToSearch = userInput.inputStrToSearch();
			menu.search(currentFileMap,strToSearch);
			displayOptions();
			break;
		case 2:
            String[] element = currentFile.get(0).split("\t");
            int selectedRow = userInput.inputSelectedRow(currentFile.size());
            int selectedColumn = userInput.inputSelectedColumn(element.length);
            menu.print(currentFile);
            System.out.println("");
            String newValue = userInput.inputNewValue();
            currentFile = menu.edit(currentFile, selectedRow, selectedColumn,newValue);
            fileIOService.writeFile(currentFile, filePath, fileName);
			
			displayOptions();
			break;
		case 3:
			menu.print(currentFile);
			displayOptions();
			break;
		case 4:
			currentFile = menu.addRow(currentFile);
            fileIOService.writeFile(currentFile, filePath, fileName);
			displayOptions();
			break;
		case 5:
            menu.print(currentFile);
            int rowToSort = userInput.inputRowToSort(currentFile.size());
			currentFile = menu.sortRow(currentFile, rowToSort);
            fileIOService.writeFile(currentFile, filePath, fileName);
			displayOptions();
			break;
		case 6:
            fileName = "newFile.txt";
            int row = userInput.inputRow();
            int column = userInput.inputColumn();
			currentFile = menu.reset(row, column);
            fileIOService.writeFile(currentFile, filePath, fileName);
			displayOptions();
			break;
		case 7:
			menu.exit();
			break;
		}
    }
    
    public void displayOptions() throws IOException, Exception{
        MenuService menu = new MenuService();
        Validator validator = new Validator();
        FileIOService fileIO = new FileIOService();
        
        Scanner input = new Scanner(System.in);
        
		int option = 0;
		boolean isNotValid = true;

		System.out.print("\n");
		System.out.println("----------OPTIONS----------");
		System.out.println("\n");
		System.out.println("   (1)     Search");
		System.out.println("   (2)     Edit");
		System.out.println("   (3)     Print");
		System.out.println("   (4)     Add Row");
		System.out.println("   (5)     Sort Row");
		System.out.println("   (6)     Reset");
		System.out.println("   (7)     Exit");
		System.out.println("\n");
		System.out.print("Select from options 1-7: ");
        int numInput = input.nextInt();
		option = validator.checkIntegerInput(numInput, 1, 7);
		
		System.out.println("\n");
        
        optionImp(option);
	}
}