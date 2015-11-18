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
        if (node.table.negatives() == 0) {
            node.atribute = 1;
            return;
        }
        if (node.table.positives() == 0) {
            node.atribute = 0;
            return;
        }

        //If no test split the data, make it a leaf with the majoriti of the target atribute
        int atr;
        //Choose the best atribute
        atr = this.chooseBestAtrib(node);
        node.atribute = atr;

        //No atribute split the data, so make the node a leaf with the majoriti of the class (either positive or negative)
        if (node.atribute == -1) {
            //System.out.println("Atribute is -1 in TeeBuidler.create");
            if (node.table.negatives() > node.table.positives()) {
                node.atribute = 0;
                return;
            }
            if (node.table.positives() >= node.table.negatives()) {
                node.atribute = 1;
                return;
            }
        }

        Table table_left = new Table(), table_right = new Table();
        node.table.splitByAtrib(node.atribute, table_left, table_right);

        //Create two children for the current node  //parameters: identifier,parent_result,atribute of split,id_child1, id_child2, table
        node.child_left = new Node(node.id + 1, "yes", -1, -1, -1, table_left);
        node.child_right = new Node(node.id + 2, "no", -1, -1, -1, table_right);
        node.id_child_left = node.id + 1;
        node.id_child_right = node.id + 2;


        TreeBuilder builder = new TreeBuilder();
        builder.create(node.child_left);
        builder.create(node.child_right);

    }

    private int chooseBestAtrib(Node node) {
        int bestAtr = -1;

        double entropy_parent = node.table.entropy();

        double max_IG = -99999.0;
        double entropy_child_left;
        double entropy_child_right;
        double information_gain;
        //Select an atribute and split by it. Make 2 fake, temporary children
        for (int atr = 1; atr < node.table.cols(); atr++) {
            Table table_left = null, table_right = null;
            table_left = new Table();
            table_right = new Table();
            node.table.splitByAtrib(atr, table_left, table_right);
            entropy_child_left = table_left.entropy();
            if (entropy_child_left==-1)
                continue;
            entropy_child_right = table_right.entropy();
            if (entropy_child_right==-1)
                continue;
            information_gain = entropy_parent - (entropy_child_left * (double) table_left.rows() / (double) node.table.rows() + (double) entropy_child_right * (double) table_right.rows() / (double) node.table.rows());
            if (information_gain > max_IG) {
                bestAtr = atr;
            }
        }

        /*if (bestAtr == -1) {
            System.out.println("Stop, atribute is -1 in TreeBuiderl.chooseBestATrib");
        }*/

        return bestAtr;

    }

}
