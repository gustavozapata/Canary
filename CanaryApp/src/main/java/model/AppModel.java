package model;

/**
 *
 * @author k1715308
 */
public class AppModel {
    final private String[] categories = new String[] {"University", "Home", "Work", "Personal"};
    final private String[] priorities = new String[] {"Low", "Medium", "High"};
    final private String[] users = new String[] {"tavo", "kylan", "paul"};
    
    public String[] getCategories(){
        return this.categories;
    }
    
    public String[] getPriorities(){
        return this.priorities;
    }
    
    public String[] getUsers(){
        return this.users;
    }
}
