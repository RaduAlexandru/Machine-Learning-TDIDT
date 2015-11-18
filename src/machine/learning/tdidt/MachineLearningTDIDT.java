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
        //Print the nodes
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){ 
            q.peek().print();
            if (q.peek().child_left!=null)
                q.add(q.peek().child_left);
            if (q.peek().child_right!=null)
                q.add(q.peek().child_right);
            q.poll();
        }
        
        
        
        
        
        
    }
    
    
    
}
