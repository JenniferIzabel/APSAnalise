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
public class MaxSubarray {

    public int enumeration(int vetor[]) {
        int tam = vetor.length;
        int somaAtual = 0;
        int maiorSoma = Integer.MIN_VALUE;

        int contIteracoes = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = i; j < tam; j++) {
                somaAtual = 0;
                for (int k = i; k < j; k++) {
                    somaAtual += vetor[k];
                }
                maiorSoma = Integer.max(somaAtual, maiorSoma);
                contIteracoes++;
            }
        }
        System.out.println("Iteracoes: " + contIteracoes);
        return maiorSoma;
    }

    public int betterEnumeration(int vetor[]) {
        int tam = vetor.length;
        int somaAtual = 0;
        int maiorSoma = Integer.MIN_VALUE;

        int contIteracoes = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = i + 1; j < tam; j++) {
                somaAtual = vetor[i];
                for (int k = i + 1; k < j; k++) {
                    somaAtual += vetor[k];
                }
                maiorSoma = Integer.max(somaAtual, maiorSoma);
                contIteracoes++;
            }
        }
        System.out.println("Iteracoes better: " + contIteracoes);
        return maiorSoma;
    }

    int contDividConq = 0;

    private int somaSubvetor(int[] vetor, int primeiro, int meio, int ultimo) {

        int somaEsquerda = Integer.MIN_VALUE;
        int soma = 0;

        for (int i = meio; i < primeiro; i--) {
            soma += vetor[i];
            somaEsquerda = Integer.max(somaEsquerda, soma);
            contDividConq++;
        }

        int somaDireita = Integer.MIN_VALUE;
        soma = 0;
        for (int i = meio + 1; i < ultimo; i++) {
            soma += vetor[i];
            somaDireita = Integer.max(somaDireita, soma);
            contDividConq++;
        }

        return somaEsquerda + somaDireita;
    }

    public int divideAndConquer(int[] vetor, int primeiro, int ultimo) {
        contDividConq++;
        if (primeiro == ultimo) {
            return vetor[primeiro];
        } else {
            int meio = (primeiro + ultimo) / 2;
            return maiorDe3(divideAndConquer(vetor, primeiro, meio),
                    divideAndConquer(vetor, meio + 1, ultimo),
                    somaSubvetor(vetor, primeiro, meio, ultimo));
        }
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

    public int dynamicPrograming(int[] vetor) {
        int tam = vetor.length;
        int somaAtual = 0;
        int maiorSoma = Integer.MIN_VALUE;

        for (int i = 0; i < tam; i++) {
            if ((somaAtual + vetor[i]) > maiorSoma) {
                somaAtual += vetor[i];
            } else {
                somaAtual = vetor[i];
            }

        }
        return maiorSoma;
    }

}
