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
        table_left = new Table();
        table_right = new Table();

        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, atribute) == 1) {
                //Put that row into table left
                table_left.addRow();
                for (int j = 0; j < this.cols(); j++) {
                    if (j != atribute) {
                        table_left.getRow(i).add(this.get(i, j));
                    }
                }
            }
            if (this.get(i, atribute) == 0) {
                //Put that row into table right
                table_right.addRow();
                for (int j = 0; j < this.cols(); j++) {
                    if (j != atribute) {
                        table_right.getRow(i).add(this.get(i, j));
                    }
                }
            }

        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double entropy() {

        double entr;
        entr = -(this.positives() / this.rows() * log2(this.positives() / this.rows())) - 
                (this.negatives() / this.rows() * log2(this.negatives() / this.rows()));
        return entr;
    }

    public static double logb(double a, double b) {
        return Math.log(a) / Math.log(b);
    }

    public static double log2(double a) {
        return logb(a, 2);
    }

    private int positives() {
        
        int positives=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, 0)==1)
                    positives++;
        }
        return positives;
        
    }

    private int negatives() {
        int negatives=0;
        for (int i = 0; i < this.rows(); i++) {
            if (this.get(i, 0)==0)
                    negatives++;
        }
        return negatives;
    }

}
