/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Nate
 */
public class AccountListRenderer extends JLabel implements ListCellRenderer<Account> {
   
    public AccountListRenderer(){
    
        setOpaque(true);
       
    
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Account> list, Account account, int index, boolean isSelected, boolean cellHasFocus) {
        String accountName = account.getAccountName();
        setText(accountName);
         if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
             setBackground(list.getBackground());
             setForeground(list.getForeground());
         }
        return this;
    }

    
}
