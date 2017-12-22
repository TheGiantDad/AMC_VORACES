/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ConjuntoTrucado {
    ArrayList<Object> elem;
    boolean [] b;
    int nelem = 0;
    
    public ConjuntoTrucado(ArrayList<Object> elem,boolean lleno){
        this.elem = elem;
        b = new boolean[elem.size()];
        if(lleno){
            for (int i = 0; i < elem.size(); i++) {
                b[i]= true;
            }
            nelem = elem.size();
        }
    }
    public boolean vacio(){
        return (nelem==0);
    }
    int traductor(Punto p){
        encapsulacion del punto
    }
}
