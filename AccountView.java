package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AccountView extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel usernameLabel, accountLabel, passwordLabel, rePasswordLabel;
    private JTextField usernameField, accountField;
    private JPasswordField passwordField, rePasswordField;
    private JButton submit, btnClose;
    
    private AccountCtrl acctCtrl = null;
    
    public AccountView(AccountCtrl acctCtrl){
        this.acctCtrl = acctCtrl;
        
        frame = new JFrame("Add a new account");
        frame.setLayout(new GridLayout(3,1));
        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        
        accountLabel = new JLabel("Account title:");
        accountField = new JTextField();
        
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        
        rePasswordLabel = new JLabel("Re-enter password:");
        rePasswordField = new JPasswordField();
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        
        accountField.setColumns(16);
        usernameField.setColumns(16);
        passwordField.setColumns(16);
        rePasswordField.setColumns(16);
        
        panel1.add(accountLabel);
        panel1.add(accountField);
        panel2.add(usernameLabel);
        panel2.add(usernameField);
        panel3.add(passwordLabel);
        panel3.add(passwordField);
        panel4.add(rePasswordLabel);
        panel4.add(rePasswordField);
        panel5.add(submit);
        panel5.add(btnClose);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.setSize(450, 300);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(submit);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Submit")){
            if(Arrays.equals(passwordField.getPassword(),rePasswordField.getPassword()) && accountField != null && passwordField != null && usernameField != null){
                String account = this.accountField.getText();
                String username = this.usernameField.getText();
                char[] password = this.passwordField.getPassword();
                Account newAccount = new Account(account, username, password);
                acctCtrl.setAccount(newAccount);
            }
            else if(!Arrays.equals(this.passwordField.getPassword(),this.rePasswordField.getPassword())){
                JOptionPane.showMessageDialog(null, "Your passwords do not match, try again!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
            }
            this.frame.setVisible(false);
            
            MainMenu newMain = new MainMenu();
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
    }
}
