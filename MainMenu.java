package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainMenu extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel label;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton btnGenerate;
    private JButton btnClose;
    private JButton btnAddAccount;
    private JButton btnView;
    
    public MainMenu(){
        frame = new JFrame("Credential Manager");
        frame.setLayout(new GridLayout(4,1));
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        
        label = new JLabel("Please choose a feature.");
        
        btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(this);
        btnAddAccount = new JButton("Add Account");
        btnAddAccount.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        btnView = new JButton("View Accounts");
        btnView.addActionListener(this);
        
        
        panel.add(label);
        panel3.add(btnGenerate);
        panel3.add(btnView);
        panel3.add(btnAddAccount);
        panel3.add(btnClose);
        
        frame.add(panel2);
        frame.add(panel);
        frame.add(panel3);
        frame.setSize(300, 280);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Generate")){
            Generator gen = new Generator();
            this.frame.setVisible(false);
        }
        else if(arg.equals("Add Account")){
            try {
                AccountCtrl acctCtrl= new AccountCtrl();
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.frame.setVisible(false);
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
        else if(arg.equals("View Accounts")){
            UserAccountView acounts = new UserAccountView();
            this.frame.setVisible(false);
        }
    }
}