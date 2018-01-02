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

class padres{
    Punto hijo;
    Punto padre;
}
      
public class Algoritmos {
    ArrayList<Punto> vertices;
    ArrayList<Arista> arbol;
    ConjuntoTrucado cVertices;
    ConjuntoTrucado descubiertos;
    
    public Algoritmos( ArrayList<Punto> v){
        vertices = v;
        cVertices = new ConjuntoTrucado(v, true);
        descubiertos = new ConjuntoTrucado(v, false);
        arbol = new ArrayList<Arista>();
    }
    public boolean Prim(){
        /*
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
        
        */
        PriorityQueue<Arista> colaristas = new PriorityQueue<Arista>(vertices.size() ^ vertices.size(),new AristasC());
        
        Punto verticeI = vertices.get(0);
        descubiertos.poner(verticeI);
        while(!cVertices.vacio()){
            for (int i = 0; i < vertices.size(); i++) {
                if(!descubiertos.esta(vertices.get(i))){
                    colaristas.add(new Arista(verticeI,vertices.get(i)));
                }
                Arista aristaañadida = colaristas.poll();
                arbol.add(aristaañadida);
                
                verticeI = aristaañadida.destino;
                descubiertos.poner(verticeI);
                cVertices.quitar(verticeI);
                
            }
            
        }
        return arbol.size() == (vertices.size() - 1);
        
    }
    public boolean kruskal(ArrayList<Arista> a){//se le pasan todas las combinaciones de aristas ordenadas por su peso O(N^2)
        padres [] tabla = new padres[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            tabla[i].hijo = vertices.get(i);
            tabla[i].padre =  vertices.get(i);
        }
        int i = 0;
        while(descubiertos.nelem < vertices.size()) {
            
            Punto origen = a.get(i).origen;
            Punto destino = a.get(i).destino;
            int idorigen=0,iddestino=0;
            for (int j = 0; j < vertices.size(); j++) {
                if(vertices.get(j).equals(origen)) idorigen = j;
                if(vertices.get(j).equals(destino)) iddestino = j;
            }
            if(!(tabla[idorigen].padre.equals(tabla[iddestino].padre))){
                arbol.add(a.get(i));
                tabla[idorigen].padre = tabla[iddestino].padre;
                descubiertos.poner(origen);
                descubiertos.poner(destino);
            }
        
            
            
            i++;
        }
        return arbol.size() == (vertices.size() - 1);
        /*
        for (int i = 0; i < a.size(); i++) {
            Punto origen = a.get(i).origen;
            Punto destino = a.get(i).destino;
            int idorigen=0,iddestino=0;
            for (int j = 0; j < vertices.size(); j++) {
                if(vertices.get(j).equals(origen)) idorigen = j;
                if(vertices.get(j).equals(destino)) iddestino = j;
            }
            if(!(tabla[idorigen].padre.equals(tabla[iddestino].padre))){
                arbol.add(a.get(i));
                tabla[idorigen].padre = tabla[iddestino].padre;
                cVertices.poner(origen);
                cVertices.poner(destino);
            }
        }*/
    }
}
