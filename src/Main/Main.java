/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.LinkedList;

/**
 *
 * @author jennifer
 */
public class Main {

    public static void main(String[] args) {
        //LinkedList<int[]> listaVetores = GeraAleatorios();
        x();
    }

    public static LinkedList<int[]> GeraAleatorios() {
        //int[] tamanhos = {128, 256, 512, 1024, 2048, 4096};
        int[] tamanhos = {128, 256};

        LinkedList<int[]> listaVetores = new GeraVetorNumerosAleatorios().GeraListaVetores(tamanhos);

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/vetores.txt", listaVetores);

        return listaVetores;
    }

    public static void x() {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

        LinkedList<int[]> listaVetores = manipulaArquivo.abrirArquivo("/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/vetores.txt");

        MaxSubarrayAlgorithms msa = new MaxSubarrayAlgorithms();

        String resultado = "";
        for (int[] vet : listaVetores) {
            int res;

            resultado += ("VETOR TAMANHO " + vet.length);

            resultado += ("\nDynamicPrograming -> ");
            long startTime = System.currentTimeMillis();
            res = msa.dynamicPrograming(vet);
            long estimatedTime = System.currentTimeMillis() - startTime;
            resultado += (estimatedTime + " milisegundos");

            resultado += ("\nDivide and Conquer -> ");
            startTime = System.currentTimeMillis();
            res = msa.divideAndConquer(vet, 0, vet.length - 1);
            estimatedTime = System.currentTimeMillis() - startTime;
            resultado += (estimatedTime + " milisegundos");

            resultado += ("\nBetter Enumeration -> ");
            startTime = System.currentTimeMillis();
            res = msa.betterEnumeration(vet);
            estimatedTime = System.currentTimeMillis() - startTime;
            resultado += (estimatedTime + " milisegundos");

            resultado += ("\nEnumeration -> ");
            startTime = System.currentTimeMillis();
            res = msa.enumeration(vet);
            estimatedTime = System.currentTimeMillis() - startTime;
            resultado += (estimatedTime + " milisegundos");
            resultado += "\n\n";

        }
        manipulaArquivo.salvarResultado("/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/resultados-java.txt", resultado);

    }

    public static void y() {

        int tamanhoVetor = 10;
        int seed = 5;

        GeraVetorNumerosAleatorios geraVetorNumerosAleatorios = new GeraVetorNumerosAleatorios(tamanhoVetor);
        GeraVetorNumerosAleatorios geraVetorNumerosAleatoriosSeed = new GeraVetorNumerosAleatorios(tamanhoVetor, seed);

        int vetorManual[] = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84}; ///Manual
        int vetorAleatorio[] = geraVetorNumerosAleatorios.getVetor(); //Totalemnte Aleatório
        int vetorAleatorioSeed[] = geraVetorNumerosAleatoriosSeed.getVetor(); //mesma seed gera semore o mesmo conjunto de dados

        MaxSubarrayAlgorithms maxSubarray = new MaxSubarrayAlgorithms();

        geraVetorNumerosAleatorios.imprimeVetor(vetorManual);
        geraVetorNumerosAleatorios.imprimeVetor();
        geraVetorNumerosAleatoriosSeed.imprimeVetor();

        System.out.println("");

        int resultado = maxSubarray.enumeration(vetorManual);
        System.out.println(resultado + " -> enumeration -> vetor manual -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.enumeration(vetorAleatorio);
        System.out.println(resultado + " -> enumeration -> vetor aleatorio -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.enumeration(vetorAleatorioSeed);
        System.out.println(resultado + " -> enumeration -> vetor aleatorio com seed " + seed + " -> tamanho " + tamanhoVetor);

        System.out.println("");

        resultado = maxSubarray.betterEnumeration(vetorManual);
        System.out.println(resultado + " -> betterEnumeration -> vetor manual -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.betterEnumeration(vetorAleatorio);
        System.out.println(resultado + " -> betterEnumeration -> vetor aleatorio -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.betterEnumeration(vetorAleatorioSeed);
        System.out.println(resultado + " -> betterEnumeration -> vetor aleatorio com seed " + seed + " -> tamanho " + tamanhoVetor);

        System.out.println("");

        resultado = maxSubarray.divideAndConquer(vetorManual, 0, vetorManual.length - 1);
        System.out.println(resultado + " -> divideAndConquer -> vetor manual -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.divideAndConquer(vetorAleatorio, 0, vetorAleatorio.length - 1);
        System.out.println(resultado + " -> divideAndConquer -> vetor aleatorio -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.divideAndConquer(vetorAleatorioSeed, 0, vetorAleatorioSeed.length - 1);
        System.out.println(resultado + " -> divideAndConquer -> vetor aleatorio com seed " + seed + " -> tamanho " + tamanhoVetor);

        System.out.println("");

        resultado = maxSubarray.dynamicPrograming(vetorManual);
        System.out.println(resultado + " -> dynamicPrograming -> vetor manual -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.dynamicPrograming(vetorAleatorio);
        System.out.println(resultado + " -> dynamicPrograming -> vetor aleatorio -> tamanho " + tamanhoVetor);

        resultado = maxSubarray.dynamicPrograming(vetorAleatorioSeed);
        System.out.println(resultado + " -> dynamicPrograming -> vetor aleatorio com seed " + seed + " -> tamanho " + tamanhoVetor);

    }
}
