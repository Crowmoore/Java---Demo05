/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.jamk.register;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author h3090
 */
public class RegisterTest {
    
    public static void main(String[] args) {

        Person person = new Person("Doctor", "Jekyll", "328645-3725");
        //write person object to file
        FileOutputStream fileOutput = null;
        ObjectOutputStream objectOutput = null;
        try {
            //create binary stream for file writing
            fileOutput = new FileOutputStream("register.dat");
            //create object stream
            objectOutput = new ObjectOutputStream(fileOutput);
            //write Person object to file
            objectOutput.writeObject(person);
        }catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }catch (IOException e) {
            System.out.println("Could not write to file");
            return;
        }finally {
            try {
                if(objectOutput != null) objectOutput.close();
                }catch (IOException e) {
                    System.out.println("File could not be closed");
                    return;
                }
        }
        
        System.out.println("Writing successful");
        
        //read Person object from file
        FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;
        
        try {
            //open binary stream for writing
            fileInput = new FileInputStream("register.dat");
            //open object stream
            objectInput = new ObjectInputStream(fileInput);
            //read Person from object stream
            person = (Person) objectInput.readObject();
            System.out.println(person.getPerson());
        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        }catch(IOException e) {
            System.out.println("Could not read file");
        }catch(ClassNotFoundException e) {
            System.out.println("Could not read Person from file");
        }finally {
            try {
                if(objectInput != null) objectInput.close();
                }catch (IOException e) {
                    System.out.println("File could not be closed");
                    return;
                }
        }
        
    }
    
    
}
