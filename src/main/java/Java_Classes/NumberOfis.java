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
public class NumberOfis implements Runnable{
        private JTable table1;
        private int row_pointer;
        File fi;
        NumberOfis (JTable table1, int row_pointer,File fi){
            this.table1 = table1;
            this.row_pointer = row_pointer;
            this.fi = fi;
        }

    @Override
    public void run() {
        try {
                int counter = 0;
                table1.setValueAt(counter, row_pointer, 2);
                String current = null;
                Scanner sc = new Scanner(new File(String.valueOf(fi)));
                
                while (sc.hasNext()) {
                    current = sc.next();
                    if("is".equals(current) || "Is".equals(current) || "IS".equals(current) ||"iS".equals(current))
                    {
                        counter++;
                        updategui(counter);
                        Thread.sleep(200);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(directory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(NumberOfis.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void updategui (int counter){
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run(){
                 table1.setValueAt(counter, row_pointer, 2);
             }
         });
         
     }
}
