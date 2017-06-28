/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author jennifer
 */
public class Main {

    public static void main(String[] args) {
        
        int tamanhoVetor = 10;
        int seed = 5;
        
        GeraVetorNumerosAleatorios geraVetorNumerosAleatorios = new GeraVetorNumerosAleatorios(tamanhoVetor);
        GeraVetorNumerosAleatorios geraVetorNumerosAleatoriosSeed = new GeraVetorNumerosAleatorios(tamanhoVetor, seed);

        int vetorManual[] = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84}; ///Manual
        int vetorAleatorio[] = geraVetorNumerosAleatorios.getVetor(); //Totalemnte Aleatório
        int vetorAleatorioSeed[] = geraVetorNumerosAleatoriosSeed.getVetor(); //mesma seed gera semore o mesmo conjunto de dados
        
        MaxSubarray maxSubarray = new MaxSubarray();

        geraVetorNumerosAleatorios.imprimeVetor(vetorManual);
        geraVetorNumerosAleatorios.imprimeVetor();
        geraVetorNumerosAleatoriosSeed.imprimeVetor();
        
        System.out.println("");
        
        int resultado = maxSubarray.enumeration(vetorManual);
        System.out.println(resultado +" -> enumeration -> vetor manual -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.enumeration(vetorAleatorio);
        System.out.println(resultado +" -> enumeration -> vetor aleatorio -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.enumeration(vetorAleatorioSeed);
        System.out.println(resultado +" -> enumeration -> vetor aleatorio com seed "+seed+" -> tamanho "+tamanhoVetor);

        System.out.println("");
        
        resultado = maxSubarray.betterEnumeration(vetorManual);
        System.out.println(resultado +" -> betterEnumeration -> vetor manual -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.betterEnumeration(vetorAleatorio);
        System.out.println(resultado +" -> betterEnumeration -> vetor aleatorio -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.betterEnumeration(vetorAleatorioSeed);
        System.out.println(resultado +" -> betterEnumeration -> vetor aleatorio com seed "+seed+" -> tamanho "+tamanhoVetor);

        System.out.println("");
        
        maxSubarray.contDividConq = 0;
        resultado = maxSubarray.divideAndConquer(vetorManual, 0, vetorManual.length-1);
        System.out.println(resultado +" -> divideAndConquer -> vetor manual -> tamanho "+tamanhoVetor);
        System.out.println("Iteracoes divConq: "+maxSubarray.contDividConq);
        
        maxSubarray.contDividConq = 0;
        resultado = maxSubarray.divideAndConquer(vetorAleatorio, 0, vetorAleatorio.length-1);
        System.out.println(resultado +" -> divideAndConquer -> vetor aleatorio -> tamanho "+tamanhoVetor);
        System.out.println("Iteracoes divConq: "+maxSubarray.contDividConq);

        maxSubarray.contDividConq = 0;
        resultado = maxSubarray.divideAndConquer(vetorAleatorioSeed, 0, vetorAleatorioSeed.length-1);
        System.out.println(resultado +" -> divideAndConquer -> vetor aleatorio com seed "+seed+" -> tamanho "+tamanhoVetor);
        System.out.println("Iteracoes divConq: "+maxSubarray.contDividConq);
        
        System.out.println("");
        
        resultado = maxSubarray.dynamicPrograming(vetorManual);
        System.out.println(resultado +" -> dynamicPrograming -> vetor manual -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.dynamicPrograming(vetorAleatorio);
        System.out.println(resultado +" -> dynamicPrograming -> vetor aleatorio -> tamanho "+tamanhoVetor);

        resultado = maxSubarray.dynamicPrograming(vetorAleatorioSeed);
        System.out.println(resultado +" -> dynamicPrograming -> vetor aleatorio com seed "+seed+" -> tamanho "+tamanhoVetor);
        

    }
}
