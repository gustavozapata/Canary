package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;



public class FileReader {
    
    private static String file;
    public static ArrayList<String> loadEverybody() throws FileNotFoundException{
        ArrayList<String> everybody = new ArrayList<String>();
        File file = new File("src/main/java/model/Users.txt"); 
        String account_type="";
        String username ="";
        String password="";
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
           account_type = sc.nextLine(); 
           username = sc.nextLine(); 
           password = sc.nextLine();
           everybody.add(username);
           everybody.add(account_type);
        }
       return everybody; 
    }
    public static int getLevelUser(String input_username, String input_password) throws FileNotFoundException{
                File file = new File("src/main/java/model/Users.txt"); 
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
               found = false;
               return Integer.parseInt(account_type);
           } 
        }  
        return 0;
    }
    public static boolean checkUser(String input_username, String input_password) throws FileNotFoundException{
        File file = new File("src/main/java/model/Users.txt"); 
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

