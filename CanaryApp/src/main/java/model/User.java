
package model;

public class User {
    private String name;
    private String password;
    private int userLevel;
    
    public User(String userName, int userLevel){
        this.setUserName(userName);
        this.setUserLevel(userLevel);
    }

    public String getUserName() {
        return this.name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserLevel() {
        return this.userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    
}
