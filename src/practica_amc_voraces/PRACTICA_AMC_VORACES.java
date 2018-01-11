/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author usuario
 */
public class PRACTICA_AMC_VORACES {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        System.out.println("empezando main");

        ArrayList<Punto> t= new ArrayList<Punto>();
        t=leerArchivo("ch150.tsp",150);//NOMBRE ARCHIVO + NUMERO DE PUNTOS(TAMAÑO)
        
        Algoritmos al=new Algoritmos(t);
        if(al.Kruskal()==true)System.out.println("true");
        //if(al.Prim()==true)System.out.println("true");
        else System.out.println("false");
        System.out.println(al.arbol.size());
        
        
        
        
        
        for (int i = 0; i < al.arbol.size(); i++) {
            System.out.println("Origen: "+al.arbol.get(i).origen +" Destino: "+al.arbol.get(i).destino + " Coste: "+al.arbol.get(i).distancia);
        }
        
        
        /*
        ArrayList<Punto> t = new ArrayList<Punto>();
        Punto p1 =new Punto(1,0);
        Punto p2 =new Punto(2,0);
        Punto p3 =new Punto(3,0);
        Punto p4 =new Punto(4,0);
        Punto p5 =new Punto(5,0);
        t.add(p1);
        t.add(p2);
        t.add(p3);
        t.add(p4);
        t.add(p5);
        
        Hashtable<Punto,Boolean> c = new Hashtable<Punto,Boolean>();
        
        for (int i = 0; i < t.size(); i++) {
            c.put(t.get(i), true);
        }
        
        if(c.get(t.get(3))) System.out.println("todo bine");
        ConjuntoTrucado c = new ConjuntoTrucado(t, false);
        c.poner(p5);
        if(c.esta(p5)) System.out.println("todo bien");
        */
        
     
    }
    
    
    
    public static ArrayList<Punto> leerArchivo(String ruta, int tam)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		ArrayList<Punto> v = new ArrayList<Punto>();
		// PRIMER ELEMENTO DE RELLENO, NO SE USA PARA EVITAR ERRORES EN LOS INDICES
		v.add(new Punto(0f, 0f));
		String linea;

                for(int i=0; i<6; i++){
                    System.out.println(br.readLine());
                }
                int contador=0;
		while (contador<tam) {
                        linea = br.readLine();
			String temp = linea.replaceAll(" +", " ").trim();
			String[] datos = temp.split(" ");
			String ciudad = datos[0];

			if (ciudad.charAt(0) >= 48 && ciudad.charAt(0) <= 57) {
				v.add(new Punto(Float.parseFloat(datos[1]), Float.parseFloat(datos[2])));
			}
                        contador++;
		}

		br.close();
		return v;
	}
    
    
    
    
    
    }