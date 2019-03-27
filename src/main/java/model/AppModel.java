package model;

/**
 *
 * @author k1715308
 */
public class AppModel {
    final private String[] categories = new String[] {"All","University", "Home", "Work", "Personal"};
    final private Integer[] priorities = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    final private String[] users = new String[] {"tavo", "kylan", "paul"};
    
    public String[] getCategories(){
        return this.categories;
    }
    
    public Integer[] getPriorities(){
        return this.priorities;
    }
    
    public String[] getUsers(){
        return this.users;
    }
}
