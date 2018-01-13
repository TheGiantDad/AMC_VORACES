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
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class PRACTICA_AMC_VORACES {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        
           ArrayList<Punto> t= new ArrayList<Punto>();
           t=null;
           Scanner sc = new Scanner(System.in);
           String fichero;
           int tamaño;

         try {
            System.out.println("Inserte nombre del archivo TSP a estudiar: ");
            fichero = sc.nextLine();
            System.out.println("Inserte tamaño del archivo TSP a estudiar: ");
            tamaño = sc.nextInt();
            t=leerArchivo(fichero+".tsp",tamaño);//NOMBRE ARCHIVO + NUMERO DE PUNTOS(TAMAÑO)
             } catch (Exception e) {System.out.println("Fallo al leer fichero");}
         
         
         if(t!=null){
               for (int i = 0; i < 15; i++) {//LIMPIAR PANTALLA
               System.out.println(); 
            }
            System.out.println("Menú");
            System.out.println("----------------");
            System.out.println("1. Algoritmo de Prim");
            System.out.println("2. Algoritmo de Kruskal");
            System.out.println();
            System.out.print("¿Qué quieres hacer?:  ");
            Scanner sc2 = new Scanner(System.in);
            String opcion = sc2.nextLine();
            switch (opcion) {
                case "1":{   
                    Algoritmos al=new Algoritmos(t);
                    if(al.Prim()==true){
                        System.out.println("Árbol de recubrimiento minimo encontrado");
                        System.out.println();
                        System.out.println("¿Desea generar el árbol(s/n)?: ");
                        Scanner sc3 = new Scanner(System.in);
                        String opcion2 = sc3.nextLine();
                        if(opcion2.equals("s")){
                            double distancia=0;
                            for (int i = 0; i < al.arbol.size(); i++) {
                                distancia=(distancia+al.arbol.get(i).distancia);
                                System.out.println("Origen: "+al.arbol.get(i).origen +" Destino: "+al.arbol.get(i).destino + " Coste: "+al.arbol.get(i).distancia);
                             }
                            System.out.println();
                            System.out.println("Distancia total: "+distancia);
                        }
                        
                    }

                    
                    else System.out.println("No ha encontrado el arbol de recubrimiento minimo");
                    //System.out.println(al.arbol.size());

                    
                      break;
                }
                case "2":   {
                    Algoritmos al=new Algoritmos(t);
                    if(al.Kruskal()==true){
                        System.out.println("Árbol de recubrimiento minimo encontrado");
                        System.out.println();
                        System.out.println("¿Desea generar el árbol(s/n)?: ");
                        Scanner sc3 = new Scanner(System.in);
                        String opcion2 = sc3.nextLine();
                        if(opcion2.equals("s")){
                            double distancia=0;
                            for (int i = 0; i < al.arbol.size(); i++) {
                                distancia=(distancia+al.arbol.get(i).distancia);
                                System.out.println("Origen: "+al.arbol.get(i).origen +" Destino: "+al.arbol.get(i).destino + " Coste: "+al.arbol.get(i).distancia);
                             }
                            System.out.println();
                            System.out.println("Distancia total: "+distancia);
                        }
                        
                    }
                    
                    
                    else System.out.println("No ha encontrado el arbol de recubrimiento minimo");
                    //System.out.println(al.arbol.size());

                    
                      break;
                }
            }
        }
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