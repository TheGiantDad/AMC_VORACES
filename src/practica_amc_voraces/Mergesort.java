/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_amc_voraces;

/**
 *
 * @author usuario
 */
public class Mergesort {
    private Punto[] numbers;
    private Punto[] helper;
    private int longitud;

    public void sort(Punto[] values) {
        this.numbers = values;
        longitud= values.length;
        this.helper = new Punto[longitud];
        mergesort(0, longitud - 1);
    }

    private void mergesort(int bajo, int alto) {
        // check if low is smaller than high, if not then the array is sorted
        if (bajo < alto) {
            // Get the index of the element which is in the middle
            int medio = bajo + (alto - bajo) / 2;
            // Sort the left side of the array
            mergesort(bajo, medio);
            // Sort the right side of the array
            mergesort(medio + 1, alto);
            // Combine them both
            merge(bajo, medio, alto);
        }
    }

    private void merge(int bajo, int medio, int alto) {

        for (int i = bajo; i <= alto; i++) {
            helper[i] = numbers[i];
        }

        int i = bajo;
        int j = medio + 1;
        int k = bajo;
        
        while (i <= medio && j <= alto) {
            if (helper[i].x <= helper[j].x) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
       
        while (i <= medio) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        

    }
}
