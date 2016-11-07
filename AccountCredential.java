/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.util.List;

/**
 *
 * @author npl5035
 */
public class AccountCredential {
    
    private final String userName;
    private String password;
    private final String accountName;
    public List<String> keywords;
    private boolean isEncrypted;
    
    public AccountCredential(String accountName, String userName){
    
        this.accountName = accountName;
        this.userName = userName;    
    }
    
    public AccountCredential(String accountName, String userName, String password){
        this.accountName = accountName;
        this.userName = userName; 
        this.password = password;
        this.isEncrypted = false;
    }
    
    public void addPassword(String newPassword){
    
        if(password.isEmpty()){
            password = newPassword;
        }
        
    }
    
    public void changePassword(String newPassword){
    
        if(isEncrypted = false && !password.isEmpty()){
            password = newPassword;
        }    
    }
    
    
    
}
