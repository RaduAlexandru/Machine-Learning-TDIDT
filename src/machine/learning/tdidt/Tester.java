/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.tdidt;

/**
 *
 * @author Alex
 */
class Tester {

    int test(Node node, Table test_table) {
        int successes=0;
        
        //Grab an example from the test table
        //run it through the node root 
        //Compare the output of the tree with the actual value from the table (the first column)
        //If it's correct increase the number of successes.
        
        Node pointer; //Ponter to the node in the tree currently being evaluated
        pointer=node;
        
        int result=-1;
        //We have the line here and we run it though the tree
        for (int row = 0; row < test_table.rows(); row++) {
            //If node is leaf return eiither 1 or 0
            //look at node.atrib and compare it with the column from the table
            //if it's 1 go left, if it's 0 go right
            test_table.getRow(row);
            pointer=node;
            
            while(true){
                //System.out.print("node testing is" );
                //pointer.print();
                if (pointer.id_child_left==-1 && pointer.id_child_right==-1){
                    result=pointer.atribute;
                    break;
                }
                //System.out.println("Test is "+test_table.get(row, pointer.atribute) );
                if (test_table.get(row, pointer.atribute)==1){
                    pointer=pointer.child_left;
                    continue;
                }
                if (test_table.get(row, pointer.atribute)==0){
                    pointer=pointer.child_right;
                    continue;
                }
            }
            
            if (result==test_table.get(row,0)){
                successes++;
            }
            
        }
               
        return successes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
