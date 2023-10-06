package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ReadTextFile {
 
private Scanner input;
 
public void openTextFile(String fileName) {
 
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            }
         }
 

    
    public void readFromFile(){
        try {
            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
        } catch (NoSuchElementException w){
             System.err.println("File improperly formed");
             System.err.println(w);
             System.exit(1);
             input.close();
        } catch (IllegalStateException w){
             System.err.println("Error reading from file");
             System.err.println(w);
             System.exit(1);
        }
    }
    
    public void closeFile(){
        if (input != null){
            input.close();
        }
    }
}

