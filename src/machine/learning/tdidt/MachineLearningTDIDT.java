/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.tdidt;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class MachineLearningTDIDT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        //Read all the atributes in an array 
        //Read all the target atributes in another array
        
        //For every atribute calculate it's information gain it's information gain
        
        //The atribute with the higher information gain will become a node
            //Let's image it is
            
        
        Table table= new Table();
        TableReader reader = new TableReader();
        reader.read("SPECT.train",table);
        
        //Printing out the table
        table.print();
        
        //create a node with parameters: identifier,parent_result,atribute of split,id_child1, id_child2, table
        Node root=new Node(1,"NULL",-1,-1,-1,table);
        TreeBuilder builder= new TreeBuilder();
        builder.create(root);
        
        //Now from root we should have all the other nodes
        
        
        //For every atribute (from each col from the index 1 onwards) calculate the information gain
         /*for (int atr = 1; atr < table.cols(); atr++) {
            //Calculate how many 1s and 0s are in the target atribute to calculate the entory of the parent
            //If we would split by this atribute (left the ones that have this atribute 1 and left the ones that are 0),
                //, calculate the number of 1's and 0s in each children
            double information_gain=0.0;
            double entropy_parent;
            double entropy_child_left;
            double entropy_child_right;
            
            int positives_parent=0;
            int negatives_parent=0;
            
            int positives_child_left=0;
            int negatives_child_left=0;
            
            int positives_child_right=0;
            int negatives_child_right=0;
            
            //Parent
            for (int row = 0; row < table.size(); row++) {
                 if (table.get(row).get(0)==1)
                     positives_parent++;
                 else
                     negatives_parent++;
            }
            
             //Children. the one on the left is the one whith the result yes (1), the right is the result no (0)
             for (int row = 0; row < table.size(); row++) {
                if (table.get(row).get(0) ==0 && table.get(row).get(atr)==0)
                    negatives_child_right++;
                if (table.get(row).get(0) ==0 && table.get(row).get(atr)==1)
                    negatives_child_left++;
                if (table.get(row).get(0) ==1 && table.get(row).get(atr)==0)
                    positives_child_left++;
                if (table.get(row).get(0) ==1 && table.get(row).get(atr)==1)
                    positives_child_right++;
            }
             
             
            
            
        }*/
        
 
         
         
         
         
         
         
        
    }
    
    
    
}
