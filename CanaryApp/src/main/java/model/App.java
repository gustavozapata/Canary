/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gustavo
 */
public class App {
    final private String[] categories = new String[] {"University", "Home", "Work", "Personal"};
    final private String[] priorities = new String[] {"High", "Medium", "Low"};
    
    enum Categories {
        University,
        Home,
        Work,
        Personal
    }
    
    enum Priorities {
        High,
        Medium,
        Low
    }
    //Categories a = Categories.Home;
}
