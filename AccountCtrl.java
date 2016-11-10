package credentialmanager;

public class AccountCtrl {
    
    private AccountView accountView = null;
    private Account account = null;
    public AccountCtrl(){
        this.accountView = new AccountView(this);
    }
    
    public void setAccount(Account acct){
        account = acct;
    }
    
}
