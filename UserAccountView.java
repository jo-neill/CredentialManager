/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

/**
 *
 * @author Nate
 */
public class UserAccountView extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel1, panel2, panel3;
    private JLabel listLabel, passwordLabel, password, userLabel, username;
    private JList accountList;
    private JScrollPane lsp;
    private JButton back, edit, addAccount;
    private String[] test = {"one", "two", "three", "four"};
    String testPass = "pass";
    char[] pass = testPass.toCharArray();
    Account test1 = new Account("gmail", "nate", pass);
    Account test2 = new Account("hotmail", "joe", pass);
    Account test3 = new Account("yahoo", "kate", pass);
    Account test4 = new Account("yahoo", "steveS", pass);
    Account test5 = new Account("yahoo", "nate", pass);
    Account test6 = new Account("yahoo", "nate", pass);
    Account test7 = new Account("yahoo", "nate", pass);
    Account test8 = new Account("yahoo", "nate", pass);
    Account test9 = new Account("yahoo", "nate", pass);
    Account test10 = new Account("yahoo", "nate", pass);
    Account[] userAcc = {test1, test2, test3, test4, test5, test6, test7, test8, test9, test10};

    public static void main(String[] args) {
        new UserAccountView();
    }

    public UserAccountView() {
        frame = new JFrame("Your Accounts");
        frame.setLayout(new GridLayout(3, 1));
        panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 218;
        c.weighty = 10;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        listLabel = new JLabel("Account List: ");
        panel1.add(listLabel, c);

        c.gridy++;
        accountList = new JList(userAcc);
        accountList.setCellRenderer(new AccountListRenderer());
        accountList.setVisibleRowCount(5);
        accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                Account temp = (Account) accountList.getSelectedValue();
                username.setText(temp.getUsername());
                password.setText(temp.getPassword());
            }
        });
        lsp = new JScrollPane(accountList);
        panel1.add(lsp, c);

        c.gridy = 0;
        c.gridx = 1;
        userLabel = new JLabel("Username: ");
        panel1.add(userLabel, c);

        c.gridy++;
        username = new JLabel("Username");
        panel1.add(username, c);

        c.gridy++;
        passwordLabel = new JLabel("Password: ");
        panel1.add(passwordLabel, c);

        c.gridy++;
        password = new JLabel("Password");
        panel1.add(password, c);

        edit = new JButton("Edit Account Details");
        edit.addActionListener(this);
        panel2.add(edit);

        addAccount = new JButton("Add New Account");
        addAccount.addActionListener(this);
        panel2.add(addAccount);

        back = new JButton("Back");
        back.addActionListener(this);
        panel3.add(back);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(435, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if (arg.equals("Back")) {
            MainMenu useCaseMenu = new MainMenu();
            this.frame.dispose();
        } else if (arg.equals("Add New Account")) {
            AccountCtrl acctCtrl = new AccountCtrl();
            this.frame.setVisible(false);
        } else if (arg.equals("Edit Account Details")) {
            EditAccountView edit = new EditAccountView();
            this.frame.setVisible(false);
        }
    }
    

}
