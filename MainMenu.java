package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton btnGenerate;
    private JButton btnClose;
    private JButton btnAddAccount;
    
    public MainMenu(){
        frame = new JFrame("Choose a feature");
        frame.setLayout(new GridLayout(3,1));
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        
        btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        btnAddAccount = new JButton("Add Account");
        btnAddAccount.addActionListener(this);
        
        panel3.add(btnGenerate);
        panel3.add(btnClose);
        panel3.add(btnAddAccount);
        
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(350, 200);
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
            AccountCtrl acctCtrl= new AccountCtrl();
            this.frame.setVisible(false);
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
    }
}