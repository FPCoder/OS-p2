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
    private TlbEntry[] cache;
    
    public int[] getPages() {
    	int[] ret = new int[cache.length];
    	
    	for (int i = 0; i < cache.length; ++i) {
    		ret[i] = cache[i].getPageNum();
    	}
    	
    	return ret;
    }
}
