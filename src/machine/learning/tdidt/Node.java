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
class Node {
    int id;
    String result_of_parent;
    int atribute;
    int id_child_left;
    int id_child_right;
    Table table;
    Node child_left; //References to those nodes
    Node child_right;
    

    Node(int _id, String _result_of_parent, int _atribute, int _id_child_left, int _id_child_right, Table _table) {
        id=_id;
        result_of_parent=_result_of_parent;
        atribute=_atribute;
        id_child_left=_id_child_left;
        id_child_right=_id_child_right;
        table=_table;
        child_left=null;
        child_right=null;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String print() {
    	
    	String result = id + " " + result_of_parent + " " + atribute;
    	
    	if(id_child_left!= -1)
    		result += " " + id_child_left;
    		
    	if(id_child_right != -1)
    		result += " " + id_child_right;;
    	
       return result;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
