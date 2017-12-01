/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author jennifer
 */
public class GeraVetorNumerosAleatorios {

    private int[] vetor;
    private int tamanho;
    private int seed = Integer.MIN_VALUE;
    private LinkedList<int[]> listaVetores;

    public GeraVetorNumerosAleatorios() {
    }

    
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

    private int[] geraVetor(int tam) {
        Random r = new Random();
        int minimo = tam - (2 * tam);
        int maximo = tam * tam;
        int[] vet = new int[tam];

        for (int i = 0; i < tam; i++) {
            vet[i] = r.nextInt((maximo - minimo) + 1) + minimo;
        }
        return vet;
    }

    private void geraVetor(Random r) {
        int minimo = this.tamanho - (2 * this.tamanho);
        int maximo = this.tamanho * this.tamanho;

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = r.nextInt((maximo - minimo) + 1) + minimo;
        }

    }
    
    public LinkedList<int[]> GeraListaVetores(int[] tamanhos) {
        listaVetores = new LinkedList<>();
        for (int u : tamanhos) {
            int [] v = geraVetor(u);
            listaVetores.add(v);
            //imprimeVetor(v);
        }

        return listaVetores;
    }


    public void imprimeVetor() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i] + " ");
        }
        System.out.println("");
    }

    public void imprimeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }

}
