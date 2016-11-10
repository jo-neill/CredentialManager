package credentialmanager;

import java.util.List;
import java.util.ArrayList;

//UserList creates a List of users
public class UserList {
    private List<User> listOfUsers;
    
    public UserList(ArrayList<User>listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public UserList() {
        listOfUsers = new ArrayList();
        createTestUsers();
    }
    //Creates test users until we have real ones
    private void createTestUsers(){
        char[] testPassword = {'p','a','s','s','w','o','r','d'};
        addUser(new User("joe", testPassword));
        addUser(new User("hyunsook", testPassword));
        addUser(new User("zach", testPassword));
        addUser(new User("nate", testPassword));
    }
    
    public List<User> getListOfUsers() {
        return listOfUsers;
    }
    
    public void addUser(User newUser){
        listOfUsers.add(newUser);
    }
}
