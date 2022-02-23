package de.cr4zyfl1x.abiprep.sort;

import java.util.Arrays;

public class SortingAlgorithm {

    public static int[] bubblesort(int[] array)
    {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertionsort(int[] array)
    {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i;
            while (j > 0 && array[j-1] > temp) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }

    public static int[] selectionsort(int[] array)
    {
        for (int i = 0; i< array.length; i++) {
           int temp = i;
           for (int j = i + 1; j < array.length; j++) {
               if (array[temp] > array[j]) {
                   temp = j;
               }
           }
           int tausch = array[i];
           array[i] = array[temp];
           array[temp] = tausch;
        }
        return array;
    }




}
