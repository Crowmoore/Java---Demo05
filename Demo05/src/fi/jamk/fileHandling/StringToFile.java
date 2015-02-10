/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.jamk.fileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author h3090
 */
public class StringToFile {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        FileWriter fileWriter = null;
        System.out.println("Enter some strings");
            try {
                fileWriter = new FileWriter("userChars3.txt");
                fileWriter.write(input.next());
            }catch (IOException e) {
                System.out.println("File could not be found");
            }finally {
                try {
                    if(fileWriter != null) fileWriter.close();
                    }catch (IOException e) {
                        System.out.println("File could not be closed");
                        return;
                     }
        }
        
        System.out.println("Writing successful");
        
    }
    
}