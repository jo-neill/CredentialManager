package credentialmanager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//GUI for the main menu
public class AppMenu extends JFrame implements ActionListener{

    private final JFrame frame;
    private final JPanel panel1, panel2;
    private final JButton btnOpenLogin, btnClose;

    public AppMenu(){
        frame = new JFrame("Welcome to the Credential Manager!");
        frame.setLayout(new GridLayout(1,2));
        
        panel1 = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        
        btnOpenLogin = new JButton("Login");
        btnOpenLogin.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        
        panel1.add(btnOpenLogin);
        panel2.add(btnClose);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Login")){
            LoginCtrl loginCtrl = new LoginCtrl();
            this.frame.setVisible(false);
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
    }
    
}
