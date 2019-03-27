package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FileReader {
    
    private static String file;
    
    
    public static boolean checkUser(String input_username, String input_password) throws FileNotFoundException{
        File file = new File("src/main/java/com/teamcanary/canaryapp/Users.txt"); 
        Scanner sc = new Scanner(file);
       
        String account_type="";
        String username ="";
        String password="";
        boolean found = false;

        while (sc.hasNextLine() && found == false) {
           account_type = sc.nextLine(); 
           username = sc.nextLine(); 
           password = sc.nextLine();
           if(input_username.equals(username) && input_password.equals(password)){
               found = true;
           }
        
        
        }
        return found;
      } 
    
    
    
    
    
    
    
    
    
} 

