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
public class TLB {
    private int ents = 8; // maximum number of entries in TLB
    private TlbEntry[] cache = new TlbEntry[ents]; // the TLB contains 8 entries
}
