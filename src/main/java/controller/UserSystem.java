
package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.User;
import view.AppView;


public class UserSystem {
    
    static ArrayList<User> loadedUsers = new ArrayList<User>(); 
    static User currentUser;
    
    public static User loadUser(String username,int level){
        User newUser = new User(username,level);
        loadedUsers.add(newUser);
        return newUser;
    }
    
    public static boolean login(String username, String password) throws FileNotFoundException{
        boolean success = FileReader.checkUser(username, password);
        if (success){
            currentUser = loadUser(username,1); // DEFUALT 1
            AppView.getInstance().setAppLogin(username);
        }
        return success;
    
    }
    
    
   
    
    
    
    
    
    
    
    
    
}
