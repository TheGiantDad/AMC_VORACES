/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class AristasC implements Comparator<Arista>{
    
    public int compare(Arista a,Arista b){
        if(a.distancia < b.distancia)return -1;
        else if(a.distancia > b.distancia)return 1;
        else return 0;
    }
}