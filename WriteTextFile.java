
package service;


import java.io.*;
import java.util.*;

public class WriteTextFile {

    private Formatter output;
    
    public void openTextFile(String fileName){
        try {
            output = new Formatter(fileName);
        } catch (SecurityException w){
            System.err.println("you do not have writing access to this file yet");
            System.err.println(w);
            System.exit(1);
            
        } catch (FileNotFoundException w){
             System.err.println("Error opening or creating file");
             System.err.println(w);
             System.exit(1);
        }
        
    }
    public void writeToFile(Service obj){ 
        try {
            output.format(obj.toString() + "\n");
        } catch (FormatterClosedException w) {
             System.err.println("Error writing to file");
             System.err.println(w);
             System.exit(1);
        }
    }
        
        
    public void closeFile() {
        if (output != null){
            output.close();
        }
    }
  
    

}