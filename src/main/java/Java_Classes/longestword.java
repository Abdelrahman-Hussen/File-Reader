/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import JFrames.Home;
/**
 *
 * @author LEGION
 */
public class longestword implements Runnable{
        private JTable table1;
        private int row_pointer;
        File fi;
        longestword (JTable table1, int row_pointer,File fi){
            this.table1 = table1;
            this.row_pointer = row_pointer;
            this.fi = fi;
        }        
    @Override
    public void run() {
                 try {
            String longestWord = "";
            String current = null;
            Scanner sc = new Scanner(new File(String.valueOf(fi)));
            
            while (sc.hasNext()) {
                current = sc.next();   
                if(current.length()>=longestWord.length()){
                   longestWord=current;
                   updategui (longestWord);
                   Thread.sleep(200);
            }
           }
        } catch (FileNotFoundException ex) {
            
        }   catch (InterruptedException ex) {
                Logger.getLogger(longestword.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void updategui (String longg){
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run(){
                 table1.setValueAt(longg, row_pointer, 5);
             }
         }); 
     }
}
