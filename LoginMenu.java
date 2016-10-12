/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author zzt5046
 */
public class LoginMenu extends JFrame implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submit;
    private JButton btnClose;
    
    public static void main(String[] args) {
        new LoginMenu();
    }
    
     public LoginMenu(){
        frame = new JFrame("Please enter your username and password.");
        frame.setLayout(new GridLayout(3,1));
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        
        usernameField.setColumns(8);
        passwordField.setColumns(8);
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel2.add(passwordLabel);
        panel2.add(passwordField);
        panel3.add(submit);
        panel3.add(btnClose);
        
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(410, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Submit")){
            JOptionPane.showMessageDialog(null, "Login");
            //Should connect with controller class
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
    }
  } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
