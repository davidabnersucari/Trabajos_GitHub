package com.example.davidpoo;

public class ArraysG1 {

    public static void imprimeMatriz(int[][] m) {

        for (int f = 0; f < m.length; f++) {

            for (int c = 0; c < m[f].length; c++) {

                System.out.print(m[f][c] + "\t");
            }

            System.out.println();
        }
    }


    public static int[][] matrizF5(int tam, int numI) {

        int[][] m = new int[tam][tam];

        for (int f = 0; f < m.length; f++) {

            for (int c = m[0].length - 1;
                 c >= m[0].length - 1 - f;
                 c--) {

                m[f][c] = numI;
                numI++;
            }
        }

        return m;
    }


    public static void main(String[] args) {

        imprimeMatriz(matrizF5(5, 0));

    }

}