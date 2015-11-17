/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.tdidt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
class TableReader {
    

    void read(String file, Table table) throws FileNotFoundException {
        int row=0,column=0;
        
        String line;
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            line = sc.nextLine();
   
            table.addRow();
            
            //Grab every line and divide it into numbers
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                int val= Integer.parseInt(scanner.next());
                table.getRow(row).add(val);
            }
            scanner.close();
            
            row++;
            System.out.println("");
        }
        sc.close();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
