/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author horch
 */
public class Merge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Path to file
        String listMail1 = "listMail1.txt";
        String listMail2 = "listMail2.txt";
        
        //Specify variables
        Scanner readLineFromFile = null;
        ArrayList<String> resultMergeMailList = new ArrayList<String>();
        //End specify variables
        
        try {
            readLineFromFile = new Scanner(new File(listMail1));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add  listMail1 to LinkedHashSet 
        while(readLineFromFile.hasNextLine()) {
            resultMergeMailList.add(readLineFromFile.nextLine());
        }
        readLineFromFile.close();
        // -----
        
        
        String line;
        try {
            readLineFromFile = new Scanner(new File(listMail2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(readLineFromFile.hasNext()) {
            line = readLineFromFile.nextLine();
            
            if( !resultMergeMailList.contains(line) ) { // Check line to contain in array 
                for(int i = 0; i < resultMergeMailList.size(); i++ ) {
                    // Compare line from listMail2 with line in resulMergeMailList
                    if( (line.compareTo(resultMergeMailList.get(i))) < 0 ) {
                        resultMergeMailList.add(i, line);
                        break;
                    } else if ( i == (resultMergeMailList.size() - 1) ){
                        resultMergeMailList.add(line);
                        break;
                    }
                }
            }
        }
        
        readLineFromFile.close();
        
        
        
        System.out.println(resultMergeMailList.toString());
        
        
    }
    
    
}
