package com.unittest;
import java.util.*;
import java.io.*;
public class UserInput {
    Validator validator = new Validator();
    private final Scanner input = new Scanner(System.in);
    
    public String inputStrToSearch() {
        System.out.println("Enter character/s to search.");
		System.out.print("1-3 character/s only: ");
		String strToSearch = validator.validateStrLength(input.nextLine());
        return strToSearch;
    }
    
    public int inputSelectedRow(int upperLimit) {
        System.out.println("Please select the row and column to edit.");
		System.out.print("Which row?: ");
        int numInput = input.nextInt();
		int selectedRow = validator.checkIntegerInput(numInput, 1, upperLimit);
        return selectedRow;
    }
    
    public int inputSelectedColumn(int upperLimit) {
        System.out.print("Which column?: ");
        int numInput = input.nextInt();
		int selectedColumn = validator.checkIntegerInput(numInput, 1, upperLimit);
        return selectedColumn;
    }
    
    public String inputNewValue() {
        System.out.print("Enter new Value up to 3 character/s only): ");
        input.nextLine();
		String str = input.nextLine();
        String newValue = validator.validateStrLength(str);
        return newValue;
    }
    
    public int inputRowToSort(int upperLimit) {
        System.out.print("Enter which row to sort: ");
        int numInput = input.nextInt();
		int rowToSort = validator.checkIntegerInput(numInput, 1, upperLimit);
        return rowToSort;
    }
    
    public int inputRow() {
        final int MAX_NUMBER = 100;
        System.out.print("Enter number of Rows: ");
        int numInput = input.nextInt();
		int row = validator.checkIntegerInput(numInput, 1, MAX_NUMBER);
        return row;
    }
    
    public int inputColumn() {
        final int MAX_NUMBER = 100;
        System.out.print("Enter number of Columns: ");
        int numInput = input.nextInt();
		int column = validator.checkIntegerInput(numInput, 1, MAX_NUMBER);
        return column;
    }
    
    
}