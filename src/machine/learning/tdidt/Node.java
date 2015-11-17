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
    int identifier;
    String result_of_parent;
    int atribute;
    int id_child_left;
    int id_child_right;
    Table table;
    Node child_left; //References to those nodes
    Node child_right;

    Node(int _identifier, String _result_of_parent, int _atribute, int _id_child_left, int _id_child_right, Table _table) {
        identifier=_identifier;
        result_of_parent=_result_of_parent;
        atribute=_atribute;
        id_child_left=_id_child_left;
        id_child_right=_id_child_right;
        table=_table;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
