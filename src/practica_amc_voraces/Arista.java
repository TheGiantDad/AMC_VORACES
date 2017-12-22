/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

/**
 *
 * @author Usuario
 */
public class Arista {
    public Punto origen;
    public Punto destino;
    public Double distancia;
    public Arista(Punto o,Punto d){
        origen = o;
        destino = d;
        distancia = Punto.distancia(o,d);
    }
}
