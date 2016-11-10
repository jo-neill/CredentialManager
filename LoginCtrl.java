package credentialmanager;

import java.util.Arrays;
//Authenticates users' credentials and any necessary controls for the login menu
public class LoginCtrl {
    private LoginMenu loginMenu;
    private UserList userList;
    
    
    public LoginCtrl() {
        this.userList = new UserList();
        this.loginMenu = new LoginMenu(this);
    }

    public boolean authenticate(String username, char[] password) {
        boolean authenticated = false;
        for (int i = 0; i < userList.getListOfUsers().size(); i++) {
            if (Arrays.equals(userList.getListOfUsers().get(i).getPassword(), password) && userList.getListOfUsers().get(i).getUsername().equalsIgnoreCase(username)) {   System.out.println("Authenticating");
                authenticated = true;
            }
        }
        
        return authenticated;
    }
}
