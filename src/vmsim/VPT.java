/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 * @author ModernCyborg
 */
public class VPT {
    private PageTableEntry[] table;
    
    public void setDbit(int i) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setDbit(true);
    }
    public void setRbit(int i) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setRbit(true);
    }
}
