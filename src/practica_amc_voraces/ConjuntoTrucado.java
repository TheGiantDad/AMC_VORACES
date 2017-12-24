/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Usuario
 */
public class ConjuntoTrucado {
    Hashtable<Punto, Boolean> c=null;
    
    int nelem = 0;
    
    public ConjuntoTrucado(ArrayList<Punto> elem,boolean lleno){
        c = new Hashtable<Punto,Boolean>();
        for (int i = 0; i < elem.size(); i++) {
            c.put( elem.get(i), lleno);
        }
        if(lleno) nelem = elem.size();
    }
    public boolean vacio(){
        return (nelem==0);
    }
    public boolean esta(Punto p){
        return c.get(p);
    }
    public void poner(Punto p){
        c.put(p,true);
        nelem++;
    }
     public void quitar(Punto p){
        c.put(p,false);
        nelem--;
    }
}
