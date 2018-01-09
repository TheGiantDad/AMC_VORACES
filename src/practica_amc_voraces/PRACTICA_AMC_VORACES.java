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
        t=leerArchivo("berlin52.tsp",52);//NOMBRE ARCHIVO + NUMERO DE PUNTOS(TAMAÑO)
        
        Algoritmos al=new Algoritmos(t);
        /*if(al.Prim()==true)System.out.println("true");
        else System.out.println("false");*/
        
        
        System.out.println(al.todasAristas(t).size());
        al.kruskal(al.todasAristas(t));
        
        
        
        /*System.out.println("solucion rapida: "+al.s.dist);
        al.SolucionLenta();
        
        System.out.println("solucion lenta: "+al.s.dist);*/
       
        
        
        
       /* for (int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i).x+" "+t.get(i).y);
        }*/
     
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