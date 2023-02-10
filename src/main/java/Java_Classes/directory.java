/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Classes;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.nio.file.*;
import java.util.stream.Stream;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import Java_Classes.longestword;
import Java_Classes.shortestword;
/**
 *
 * @author LEGION
 */
public class directory {
    private String filepath;
    private String internalpath;
    private int row_pointer = 0;
    private File fi;
    
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
   
    public void list(JTable table) throws FileNotFoundException, InterruptedException{
    DefaultTableModel dtm = new DefaultTableModel();
        table.setModel(dtm);
        dtm.addColumn("File name");
        dtm.addColumn("No. of words");
        dtm.addColumn("No. of 'Is'");
        dtm.addColumn("No. of 'Are'");
        dtm.addColumn("No. of 'You'");
        dtm.addColumn("Longest word");
        dtm.addColumn("Shortest word");
        File sourceFolder = new File(filepath);                          
          String FileExt = "";
          for (File sourceFile : sourceFolder.listFiles()){
              String filename = sourceFile.getName();
              FileExt = filename.substring(filename.lastIndexOf(".")+1);
              if(FileExt.equalsIgnoreCase("txt")){         
                  fi = sourceFile; 
                   dtm.addRow(new Object[]{"","","","","","",""});
                   NumberOfwords words = new NumberOfwords(table, row_pointer, fi);
                   Thread w = new Thread(words);
                   w.start();
                   NumberOfis is = new NumberOfis(table, row_pointer, fi);
                   Thread i = new Thread(is);
                   i.start();
                   NumberOfare are = new NumberOfare(table, row_pointer, fi);
                   Thread a = new Thread(are);
                   a.start();
                   NumberOfyou you = new NumberOfyou(table, row_pointer, fi);
                   Thread y = new Thread(you);
                   y.start();
                   longestword longg = new longestword(table, row_pointer, fi);
                   Thread l = new Thread(longg);
                   l.start();
                   shortestword shortt = new shortestword(table, row_pointer, fi);
                   Thread s = new Thread(shortt);
                   s.start();          
                   dtm.setValueAt(filename,row_pointer, 0);
                   this.row_pointer ++; 
              }
          }      

    }
     public void listdir(JTable table) throws FileNotFoundException, InterruptedException{
    DefaultTableModel dtm = new DefaultTableModel();
        table.setModel(dtm);
        dtm.addColumn("File name");
        dtm.addColumn("No. of words");
        dtm.addColumn("No. of 'Is'");
        dtm.addColumn("No. of 'Are'");
        dtm.addColumn("No. of 'You'");
        dtm.addColumn("Longest word");
        dtm.addColumn("Shortest word");
        File dir = new File(filepath);
        String[] subdir = dir.list();
        for(int k = 0 ; k < subdir.length ; k++)
        {
            if(subdir[k].contains(".") == true)
            continue;
            File sourceFolder = new File(String.valueOf(filepath) + "/".concat(subdir[k]));                               ////                 من هنا 
          String FileExt = "";
          for (File sourceFile : sourceFolder.listFiles()){
              String filename = sourceFile.getName();
              FileExt = filename.substring(filename.lastIndexOf(".")+1);
              if(FileExt.equalsIgnoreCase("txt")){
                  fi = sourceFile;           
                   dtm.addRow(new Object[]{"","","","","","",""});
                   NumberOfwords words = new NumberOfwords(table, row_pointer, fi);
                   Thread w = new Thread(words);
                   w.start();
                   NumberOfis is = new NumberOfis(table, row_pointer, fi);
                   Thread i = new Thread(is);
                   i.start();
                   NumberOfare are = new NumberOfare(table, row_pointer, fi);
                   Thread a = new Thread(are);
                   a.start();
                   NumberOfyou you = new NumberOfyou(table, row_pointer, fi);
                   Thread y = new Thread(you);
                   y.start();
                   longestword longg = new longestword(table, row_pointer, fi);
                   Thread l = new Thread(longg);
                   l.start();
                   shortestword shortt = new shortestword(table, row_pointer, fi);
                   Thread s = new Thread(shortt);
                   s.start();
                   
                   dtm.setValueAt(filename,row_pointer, 0);
                   this.row_pointer ++;  
              }
          }    
        }            
    }
    public void listnull(JTable table) throws FileNotFoundException{
    DefaultTableModel dtm = new DefaultTableModel();
        row_pointer = 0;
        table.setModel(dtm);
        dtm.addColumn("File name");
        dtm.addColumn("No. of words");
        dtm.addColumn("No. of 'Is'");
        dtm.addColumn("No. of 'Are'");
        dtm.addColumn("No. of 'You'");
        dtm.addColumn("Longest word");
        dtm.addColumn("Shortest word");      
        dtm.addRow(new Object[]{" "," "," "," "," "," "," "});      
}
}
