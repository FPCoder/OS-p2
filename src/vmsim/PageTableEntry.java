/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 * @author ejones
 */
public class PageTableEntry {
    // INST. NOTE: the page offset is 8 bits
    private boolean vbit;
    private boolean rbit;
    private boolean dbit;
    private int pageFrameNum;
    
    public void setDbit(boolean d) { dbit = d; }
    public void setRbit(boolean r) { rbit = r; }
}
