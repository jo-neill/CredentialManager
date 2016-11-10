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
import javax.swing.JTextField;

public class GeneratorView extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel numCharsLabel;
    private JTextField numCharsField;
    private JButton submit;
    private JButton btnClose;
    
    private Generator gen = null;
    
    public GeneratorView(Generator gen){
        this.gen = gen;
        
        frame = new JFrame("Generate a password");
        frame.setLayout(new GridLayout(3,1));
        panel = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        
        numCharsLabel = new JLabel("Enter the desired number of characters in your password:");
        numCharsField = new JTextField();
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        btnClose = new JButton("Close");
        btnClose.addActionListener(this);
        
        numCharsField.setColumns(24);
        
        panel.add(numCharsLabel);
        panel.add(numCharsField);
        panel3.add(submit);
        panel3.add(btnClose);
        
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(350, 200);
        frame.setResizable(false);
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
            int passwordLength = Integer.parseInt(numCharsField.getText());
            String password = gen.getPassword(passwordLength);
            this.frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "Your newly generated password is " + password);
            MainMenu newMain = new MainMenu();
        }
        else if(arg.equals("Close")){
            System.exit(0);
        }
    }
}