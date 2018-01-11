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
    ConjuntoTrucado cVertices;
    ConjuntoTrucado descubiertos;
    
    public Algoritmos( ArrayList<Punto> v){
        vertices = v;
        //System.out.println("el conjunto tiene "+v.size()+" putnos");
        cVertices = new ConjuntoTrucado(v, true);
        descubiertos = new ConjuntoTrucado(v, false);
        arbol = new ArrayList<Arista>();
    }
    public boolean Prim(){
        
        AristasC comparador = new AristasC();
        
        PriorityQueue<Arista> colaristas = new PriorityQueue<Arista>(vertices.size(),comparador);
        
        Punto verticeI = vertices.get(0);
        //System.out.println(verticeI.x+" "+verticeI.y);
        descubiertos.poner(verticeI);
        cVertices.quitar(verticeI);
        while(!cVertices.vacio()){//EL BUCLE SE EJECUTA N VECES 
            for (int i = 0; i < vertices.size(); i++) {// ESTE SE EJECUTA TAMBIEN N VECES
                if(!descubiertos.esta(vertices.get(i))){
                    Arista al = new Arista(verticeI,vertices.get(i));
                    colaristas.add(al);
                    //System.out.println("Origen: "+al.origen +" Destino: "+al.destino + " Coste: "+al.distancia);
                }
            }
                Arista aristaañadida= null;
                do{
                     aristaañadida = colaristas.poll();
                }while(descubiertos.esta(aristaañadida.destino));// DE 0 A N VECES
                
                arbol.add(aristaañadida);
                
                verticeI = aristaañadida.destino;
                descubiertos.poner(verticeI);
                // CUALQUIER OPERACION DEL CONJUNTO TRUCADO ES DEL ORDEN CONSTANTE EN UN CASO MEDIO Y MEJOR 
                //Y EN UN CASO PEOR DE ORDEN N
                cVertices.quitar(verticeI);
                
                
            
            
        }
        return arbol.size() == (vertices.size() - 1);
        
    }
    class padres{
    Punto hijo;
    Punto padre;
    padres(Punto hijo,Punto padre){
        this.hijo=hijo;
        this.padre=padre;
    }
}
    public boolean Kruskal(){//se le pasan todas las combinaciones de aristas ordenadas por su peso O(N^2)
        ArrayList<Arista> a= todasAristas(vertices);
        ArrayList<padres> tabla = new ArrayList<padres>();
        for (int i = 0; i < vertices.size(); i++) {
            tabla.add(new padres(vertices.get(i),vertices.get(i)));
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
            if(!(tabla.get(idorigen).padre.equals(tabla.get(iddestino).padre))){
                arbol.add(a.get(i));
                tabla.get(idorigen).padre = tabla.get(iddestino).padre;
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
    
    
    public ArrayList<Arista> todasAristas(ArrayList<Punto> t){
    
        ArrayList<Arista> a = new ArrayList<Arista>();
        PriorityQueue<Arista> ar;
        ar = new PriorityQueue<Arista>(vertices.size(),new AristasC());
        
        for (int i = 0; i < t.size(); i++) {
            for (int j = 0; j < t.size(); j++) {
                if(j>i){
                    Arista aux= new Arista(t.get(i), t.get(j));
                    ar.add(aux);
    
                }
            }
            
            
        }
        while(ar.size()>0){
            a.add(ar.poll());
        }
        System.out.println("he generado este numero de aristas "+ a.size());
        return a;  
    }
    
    
    
}
