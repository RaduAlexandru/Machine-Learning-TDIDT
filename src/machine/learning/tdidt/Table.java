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
                System.out.print(this.get(i,j) + ",");
                
            }
            System.out.println("");
        }
        System.out.println("table has rows"+ this.rows() + "and column" + this.cols() );
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
