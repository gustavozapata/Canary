package model;

public class App {
    final private String[] categories = new String[] {"University", "Home", "Work", "Personal"};
    final private String[] priorities = new String[] {"High", "Medium", "Low"};
    
    enum Categories {
        University,
        Home,
        Work,
        Personal
    }
    //Categories a = Categories.Home;
    enum Priorities {
        High,
        Medium,
        Low
    }
    
    public String[] getCategories(){
        return this.categories;
    }
    
    public String[] getPriorities(){
        return this.priorities;
    }
}
