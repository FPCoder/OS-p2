/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class Memory {
    private int[][] RAM;
    
    /**
     * Initializes the cache with 'n' pages. Given page size is 1 KB or 1024 B.
     * @param n number of pages in cache
     */
    Memory(int n) {
        RAM = new int[n][1024];
    }
}
