/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Usuario
 */
public class Algoritmos {
    ArrayList<Punto> vertices;
    ArrayList<Arista> arbol;
    
    public Algoritmos( ArrayList<Punto> v){
        vertices = v;
    }
    public void Prim(){
        while(conjunto de vertices no este vacio){
            vertice i expande sus aristas que no conecte con un vertice ya añadido
                    for todas las aristas almacenadas{
                        escoger la de menor coste "c" 
                    }
                    quitamos c y la ponemos en el conjunto del arbol
                    i = vertice descubierto;
                    añadir i al arbol
                    
        }
        
        
        
        cola de prioridad aristas = new cola...(inicialmente vacia)
        Conjunto<vertices> ver = new Conjunto<vertices>(array list de todos los vertices)
        arraylist aristas finales;
        while(!ver.empty()){
            for(int i = 0; i < numero de vertices ; i++) {
               if(ver.esta(vertice[i] )
               cola prioridad<Aristas> s.add (new vertice(verticeporelquevamos,vertice[i],distancia(verticeporelquevamos,vertice[i])))
                       
            }
            conjuntoaristasfinales.añadir(s.desencolar())
            verticeporelquevamos= el destino de lo desencolado;
            ver.quitar(verticeporelquevamos)
                    
        }
    }
}
