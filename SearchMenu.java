/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

/**
 *
 * @author zzt5046*/
 import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchMenu extends JFrame implements ActionListener{
    
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel searchBarLabel;
    private JTextField searchBar;
    private JComboBox accountGroups;
    private JButton search;
    private JButton btnClose;
    
    public static void main(String[] args) {
        new SearchMenu();
    }
    
     public SearchMenu(){
        frame = new JFrame("Please enter your search terms.");
        frame.setLayout(new GridLayout(3,1));
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        
        searchBarLabel = new JLabel("Search keywords:");
        searchBar = new JTextField();
        searchBar.setColumns(20);
        
        String[] accts = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        accountGroups = new JComboBox(accts);
        
        search = new JButton("Submit");
        search.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        
        
        panel.add(searchBarLabel);
        panel.add(searchBar);
        panel2.add(accountGroups);
        panel3.add(search);
        panel3.add(btnClose);
        
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(410, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
     }
  
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
