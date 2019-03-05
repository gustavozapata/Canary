
package model;

public class User {
    private String givenName;
    private String familyName;
    private String userName;
    private String password;
    
    public User(String givenName, String familyName, String userName, String password){
        
        this.setGivenName(givenName);
        this.setFamilyName(familyName);
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
