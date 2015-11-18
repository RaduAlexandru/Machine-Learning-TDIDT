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
class TreeBuilder {

    void create(Node node) {
        //If all the targets atribute is perfectly clasified (only 0s or 1s) then node is a leaf node
        
        //If no test split the data, make it a leaf with the majoriti of the target atribute
        
        
        int atr;
        //Choose the best atribute
        atr=this.chooseBestAtrib(node);
        node.atribute=atr;
        
        Table table_left = null, table_right = null;
        node.table.splitByAtrib(node.atribute,table_left,table_right);
        
        //Create two children for the current node  //parameters: identifier,parent_result,atribute of split,id_child1, id_child2, table
        node.child_left=new Node(node.id+1,"yes",-1,-1,-1,table_left);
        node.child_right=new Node(node.id+2,"no",-1,-1,-1,table_right);
        node.id_child_left=node.id+1;
        node.id_child_right=node.id+2;
        
        
        TreeBuilder builder=new TreeBuilder();
        builder.create(node.child_left);
        builder.create(node.child_right);
        
        
        
    }

    private int chooseBestAtrib(Node node) {
        int bestAtr=-1;
        
        double entropy_parent= node.table.entropy();
        
        double max_IG=-99999.0;
        //Select an atribute and split by it. Make 2 fake, temporary children
        for (int atr = 0; atr < node.table.cols()-1; atr++) {
            Table table_left = null, table_right = null;
            node.table.splitByAtrib(atr,table_left,table_right);
            double entropy_child_left=table_left.entropy();
            double entropy_child_right=table_right.entropy();
            double information_gain=entropy_parent- (entropy_child_left*table_left.rows()/node.table.rows()  +  entropy_child_right*table_right.rows()/node.table.rows());
            if (information_gain>max_IG)
                bestAtr=atr;
        }
        
        return bestAtr;
        
    }
    
}
