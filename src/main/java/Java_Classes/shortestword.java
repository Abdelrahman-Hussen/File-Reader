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
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author LEGION
 */
public class shortestword implements Runnable{
        private JTable table1;
        private int row_pointer;
        File fi;
        shortestword (JTable table1, int row_pointer,File fi){
            this.table1 = table1;
            this.row_pointer = row_pointer;
            this.fi = fi;
        }
        
    public shortestword() {
        
    }

    @Override
    public void run() {
            try {
                Scanner sc = new Scanner(new File(String.valueOf(fi)));
                String current = "*****************************************************************************************************************************************************";
                String ShortestWord = current;
                while (sc.hasNext()) {
                    current = sc.next();
                    
                    if(current.length()<ShortestWord.length()){
                        ShortestWord=current;
                        updategui(ShortestWord);
                        Thread.sleep(200);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(shortestword.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(shortestword.class.getName()).log(Level.SEVERE, null, ex);
            }        
        } 

    public void updategui (String longg){
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run(){
                 table1.setValueAt(longg, row_pointer, 6);
             }
         });
         
     }
}