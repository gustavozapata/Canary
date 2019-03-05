package model;

/**
 *
 * @author k1715308
 */
public class AppModel {
    final private String[] categories = new String[] {"University", "Home", "Work", "Personal"};
    final private String[] priorities = new String[] {"High", "Medium", "Low"};
    
    public String[] getCategories(){
        return this.categories;
    }
    
    public String[] getPriorities(){
        return this.priorities;
    }
}
