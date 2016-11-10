package credentialmanager;
import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{
    
    private final String username;
    private char[] password;
    private String accountName;
    public List<String> keywords;
    private boolean isEncrypted;
    
    public Account(String accountName, String username, char[] password){
        this.accountName = accountName;
        this.username = username; 
        this.password = password;
        this.isEncrypted = false;
    }
    
    public void addPassword(char[] newPassword){
    
        if(password==null){
            password = newPassword;
        }
        
    }
    
    public void changePassword(char[] newPassword){
    
        if(isEncrypted == false && !(password==null)){
            password = newPassword;
        }    
    }
    
    public String toString(){
        return "Account: " + accountName + "\n" + "Username: " + username + "\n" + "Password: " + password.toString();
    }
    
    
    
}