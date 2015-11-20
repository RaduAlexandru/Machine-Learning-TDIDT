/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.tdidt;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class MachineLearningTDIDT {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //Read all the atributes in an array 
        //Read all the target atributes in another array
        
        //For every atribute calculate it's information gain it's information gain
        
        //The atribute with the higher information gain will become a node
            //Let's image it is
            
        double average_accuracy=0.0;
            
        for (int i = 0; i < 10; i++) {
            
        
    	//Grab the lerarning data
        Table table= new Table();
        TableReader reader = new TableReader();
        reader.read("SPECT.train",table);
        
        //Grab the test data
        Table test_table= new Table();
        reader.read("SPECT.test",test_table);
        
        //Randomize Tables
        table.union(test_table);
        test_table = table.shuffleAndSplit();
        
        //Printing out the table
        //table.print();
        
        //create a node with parameters: identifier,parent_result,atribute of split,id_child1, id_child2, table
        Node root=new Node(1,"-1",-1,-1,-1,table);
        TreeBuilder builder= new TreeBuilder();
        builder.create(root);
        
        //Now from root we should have all the other nodes
        //Print the nodes
        TableWriter writer= new TableWriter();
        writer.write(root);
        
        

      
        Tester tester=new Tester();
        int successes=0;
        successes=tester.test(root,test_table);
        double accuracy=(double)successes/(double)test_table.rows();
        //System.out.println("Acuracy of " + accuracy);
        
        average_accuracy+=accuracy;
        
        }
        
        System.out.println("Acuracy of " + average_accuracy/10);
        
        
        
    }


    
    
    
}
