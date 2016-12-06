/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
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

/**
 *
 * @author Nate
 */
public class EditAccountView implements ActionListener{

    private JFrame editFrame;
    private JPanel editPanel1,editPanel2,editPanel3;
    private JLabel usernameLabel, accountLabel, passwordLabel, rePasswordLabel;
    private JTextField usernameField, accountField;
    private JPasswordField passwordField, rePasswordField;
    private JButton submit, btnClose;
    public Account tempAccount;
    

    public EditAccountView() {
        
        editFrame = new JFrame("Edit account");

        editFrame.setLayout(new GridLayout(2,3));
        editPanel1 = new JPanel(new FlowLayout());
        editPanel2 = new JPanel(new FlowLayout());
        editPanel3 = new JPanel(new FlowLayout());

        accountLabel = new JLabel("Account title:");
        accountField = new JTextField();

        usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

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

        editPanel1.add(accountLabel);
        editPanel1.add(accountField);
        editPanel1.add(usernameLabel);
        editPanel1.add(usernameField);
        editPanel2.add(passwordLabel);
        editPanel2.add(passwordField);
        editPanel2.add(rePasswordLabel);
        editPanel2.add(rePasswordField);
        editPanel3.add(submit);
        editPanel3.add(btnClose);

        editFrame.add(editPanel1);
        editFrame.add(editPanel2);
        editFrame.add(editPanel3);
        editFrame.setSize(450, 300);
        editFrame.setResizable(true);
        editFrame.setLocationRelativeTo(null);
        editFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        editFrame.setVisible(true);
        editFrame.getRootPane().setDefaultButton(submit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if (arg.equals("Submit")) {
            if (Arrays.equals(passwordField.getPassword(), rePasswordField.getPassword()) && accountField != null && passwordField != null && usernameField != null) {
                String account = this.accountField.getText();
                String username = this.usernameField.getText();
                char[] password = this.passwordField.getPassword();
                tempAccount = new Account(account, username, password);
            } else if (Arrays.equals(this.passwordField.getPassword(), this.rePasswordField.getPassword())) {
                JOptionPane.showMessageDialog(null, "Your passwords do not match, try again!");
            } else {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
            }
            this.editFrame.setVisible(false);

            MainMenu newMain = new MainMenu();
        } else if (arg.equals("Close")) {
            UserAccountView userAccountView = new UserAccountView();
            this.editFrame.dispose();
        }
    }
}
