/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author jennifer
 */
public class GeraVetorNumerosAleatorios {

    private int[] vetor;
    private int tamanho;
    private int seed = Integer.MIN_VALUE;

    public GeraVetorNumerosAleatorios(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new int[this.tamanho];

    }

    public GeraVetorNumerosAleatorios(int tamanho, int seed) {
        this.tamanho = tamanho;
        this.seed = seed;
        this.vetor = new int[this.tamanho];

    }

    public int[] getVetor() {
        if (this.seed != Integer.MIN_VALUE) {
            Random r = new Random(this.seed);
            geraVetor(r);
        } else {
            Random r = new Random();
            geraVetor(r);
        }
        return this.vetor;
    }

    private void geraVetor(Random r) {
        int minimo = this.tamanho - (2 * this.tamanho);
        int maximo = this.tamanho * this.tamanho;

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = r.nextInt((maximo - minimo) + 1) + minimo;
        }
    }

    public void imprimeVetor() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i] + " ");
        }
        System.out.println("");
    }

    public void imprimeVetor(int[]v) {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }

}
