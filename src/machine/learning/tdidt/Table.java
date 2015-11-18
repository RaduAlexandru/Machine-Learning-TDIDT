/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.tdidt;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
class Table {

    ArrayList<ArrayList<Integer>> data = new ArrayList<>();

    int rows() {
        return data.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int cols() {
        return data.get(0).size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Integer get(int i, int j) {
        return data.get(i).get(j);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addRow() {
        data.add(new ArrayList<>());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList getRow(int row) {
        return data.get(row);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void print() {
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.cols(); j++) {
                System.out.print(this.get(i, j) + ",");

            }
            System.out.println("");
        }
        System.out.println("table has rows" + this.rows() + "and column" + this.cols());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void splitByAtrib(int atribute, Table table_left, Table table_right) {
        //grabs an atribute and splits by the atribute into two other tables, the one on the left (1s) on that atrib and right (0s) on the specified atrib

        //I think you also leave out the column of that atribute but i'm not sure

        if (atribute==-1)
            System.out.println("stop, atribute is -1 in Table.splitbyatrib");
        
        int child_row=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, atribute) == 1) {
                //Put that row into table left
                table_left.addRow();
                for (int j = 0; j < this.cols(); j++) {
                    if (j != atribute) {
                        //int val=this.get(i, j);
                        table_left.getRow(child_row).add(this.get(i, j));
                    }
                }
                child_row++;
            }
        }
        child_row=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, atribute) == 0) {
                //Put that row into table right
                table_right.addRow();
                for (int j = 0; j < this.cols(); j++) {
                    if (j != atribute) {
                        table_right.getRow(child_row).add(this.get(i, j));
                    }
                }
                child_row++;
            }

        }
        
        //System.out.println("finalizing split");

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double entropy() {

        if (this.rows()==0){
            System.out.println("stop, division by 0 in table.entropy");
            //By splitting with this we gain a table that has no rows, and therefoew we won't gain any infrmation. Return a -1 to indicate to go and check the next atribute
            return -1;
        }
        double entr=0.0;
        
        double test1=this.positives();
        double rows_test=this.rows();
        double divison= this.positives() / this.rows();
        double log_1=log2(this.positives() / this.rows());
        
        entr = -((double)this.positives() / (double)this.rows() * log2((double)this.positives() / (double)this.rows())) - 
                ((double)this.negatives() / (double)this.rows() * log2((double)this.negatives() / (double)this.rows()));
        return entr;
    }

    public  double logb(double a, double b) {
        double test=Math.log(a) / Math.log(b);
        return Math.log(a) / Math.log(b);
    }

    public  double log2(double a) {
        double test=a;
        return logb(a, 2);
    }

    public int positives() {
        
        int positives=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, 0)==1)
                    positives++;
        }
        return positives;
        
    }

    public int negatives() {
        int negatives=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, 0)==0)
                    negatives++;
        }
        return negatives;
    }

}
