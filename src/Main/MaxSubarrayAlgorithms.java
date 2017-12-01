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
public class MaxSubarrayAlgorithms {

    public int dynamicPrograming(int[] vetor) {
        int maior = vetor[0];
        int[] soma = new int[vetor.length];
        soma[0] = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            soma[i] = Math.max(vetor[i], soma[i - 1] + vetor[i]);
            maior = Math.max(maior, soma[i]);
        }
        return maior;

    }


    private int somaSubvetor(int[] vetor, int primeiro, int meio, int ultimo) {

        int somaEsquerda = Integer.MIN_VALUE;
        int soma = 0;

        for (int i = meio; i >= primeiro; i--) {
            soma += vetor[i];
            somaEsquerda = Integer.max(somaEsquerda, soma);
        }

        int somaDireita = Integer.MIN_VALUE;
        soma = 0;
        for (int i = meio + 1; i <= ultimo; i++) {
            soma += vetor[i];
            somaDireita = Integer.max(somaDireita, soma);
        }

        return somaEsquerda + somaDireita;
    }

    private int maiorDe3(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public int divideAndConquer(int[] vetor, int primeiro, int ultimo) {
        if (primeiro == ultimo) {
            return vetor[primeiro];
        } else {
            int meio = (primeiro + ultimo) / 2;
            return maiorDe3(divideAndConquer(vetor, primeiro, meio),
                    divideAndConquer(vetor, meio + 1, ultimo),
                    somaSubvetor(vetor, primeiro, meio, ultimo));
        }
    }

    public int betterEnumeration(int vetor[]) {
        int tam = vetor.length;
        int somaAtual = 0;
        int maiorSoma = Integer.MIN_VALUE;

        for (int i = 0; i < tam; i++) {
            for (int j = i + 1; j < tam; j++) {
                somaAtual = vetor[i];
                for (int k = i + 1; k < j; k++) {
                    somaAtual += vetor[k];
                }
                maiorSoma = Integer.max(somaAtual, maiorSoma);
            }
        }
        return maiorSoma;
    }

    public int enumeration(int vetor[]) {
        int tam = vetor.length;
        int somaAtual = 0;
        int maiorSoma = Integer.MIN_VALUE;

        for (int i = 0; i < tam; i++) {
            for (int j = i; j < tam; j++) {
                somaAtual = 0;
                for (int k = i; k < j; k++) {
                    somaAtual += vetor[k];
                }
                maiorSoma = Integer.max(somaAtual, maiorSoma);
            }
        }
        return maiorSoma;
    }

}
