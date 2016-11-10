package credentialmanager;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username = "";
    private char[] password = {};
    private List<Account> accountList;
    
    public User(String newUsername, char[] newPassword) {
        username = newUsername;
        password = newPassword;
        accountList = new ArrayList();
    }
    
    public String getUsername() {
        return username;
    }
    
    public char[] getPassword() {
        return password;
    }
    
    public List<Account> getAccountList() {
        return accountList;
    }
    
    public void addAccount(Account acct){
        accountList.add(acct);
    }
    
    
    /*
    Will add field failedTries, method addFieldTry(), and another method in LoginCtrl that keeps track of failed tries to sign into a username
    and only allows a certain amount of failed tries over the course of a period of time
    */
    
}
