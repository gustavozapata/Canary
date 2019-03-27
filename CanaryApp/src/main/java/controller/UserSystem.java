
package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.User;
import view.AppView;


public class UserSystem {
    
    public static ArrayList<User> loadedUsers = new ArrayList<User>(); 
    public static ArrayList<String> loadedUsernames = new ArrayList<String>();
    public static User currentUser;
    
    public static void loadEverybody() throws FileNotFoundException{
        ArrayList<String> newUsers = new ArrayList<String>();
        newUsers = FileReader.loadEverybody();
        for (int i = 0; i < newUsers.size(); i+=2) {
            loadUser(newUsers.get(i),Integer.parseInt(newUsers.get(i+1)));
        }
        
        
    }
    
    public static User loadUser(String username,int level){
        User newUser = new User(username,level);
        if(!loadedUsernames.contains(username)){            
            loadedUsers.add(newUser);
            loadedUsernames.add(newUser.getUserName());
        }
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
