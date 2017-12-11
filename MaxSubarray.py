# -*- coding: utf-8 -*-
import sys
import time


class MaxSubarray:

    def __init__(self, vetor):
        string_resultado = "VETOR TAMANHO "+str(len(vetor))
        
        string_resultado += "\nDynamic Programing -> "
        inicio = time.clock()
        res = self.dynamicPrograming(vetor)
        total = time.clock() - inicio
        string_resultado += str(int(total*1000)) + " ms"

        string_resultado += "\nDivide and Conquerer -> "
        inicio = time.clock()
        res = self.divideAndConquer(vetor, 0, len(vetor)-1)
        total = time.clock() - inicio
        string_resultado += str(int(total*1000)) + " ms"

        string_resultado += "\nBetter Enumeration -> "
        inicio = time.clock()
        res = self.betterEnumeration(vetor)
        total = time.clock() - inicio
        string_resultado += str(int(total*1000)) + " ms"

        string_resultado += "\nEnnumeration -> "
        inicio = time.clock()
        res = self.enumeration(vetor)
        total = time.clock() - inicio
        string_resultado += str(int(total*1000)) + " ms"
        string_resultado += "\n"

        print string_resultado


    def  dynamicPrograming(self, vetor) :
        maior = vetor[0]
        tam = len(vetor)
        soma = [tam]
        soma[0] = vetor[0]

        for i in range(1, tam):
            soma.append(max(vetor[i], (soma[i - 1] + vetor[i])))
            maior = max(maior, soma[i])
        
        return maior


    def  somaSubvetor(self, vetor,  primeiro,  meio,  ultimo) :

        somaEsquerda = 0
        soma = 0

        for i in range(meio, primeiro, -1): 
            soma += vetor[i]
            somaEsquerda = max(somaEsquerda, soma)
        

        somaDireita = 0
        soma = 0
        for i in range(meio+1, ultimo):
            soma += vetor[i]
            somaDireita = max(somaDireita, soma)
        

        return somaEsquerda + somaDireita
    

    def  maiorDe3(self, a,  b,  c) :
        if (a > b and a > c) :
            return a
        elif (b > a and b > c) :
            return b
        else :
            return c
        
    
    def  divideAndConquer(self, vetor,  primeiro,  ultimo): 
        if (primeiro == ultimo) :
            return vetor[primeiro]
        else : 
            meio = (primeiro + ultimo) / 2 
          
            a = self.divideAndConquer(vetor, primeiro, meio)
            b = self.divideAndConquer(vetor, meio + 1, ultimo)
            c = self.somaSubvetor(vetor, primeiro, meio, ultimo)

            return self.maiorDe3(a, b, c)
    

    def  betterEnumeration(self, vetor) :
        tam = len(vetor)
        somaAtual = 0
        maiorSoma = 0

        for i in range(0, tam):
            for j in range(i+1, tam):
                somaAtual = vetor[i]
                for k in range(i+1, j): 
                    somaAtual += vetor[k]
                
                maiorSoma = max(somaAtual, maiorSoma)
            
        
        return maiorSoma


    def  enumeration(self, vetor):
        tam = len(vetor)
        maiorSoma = vetor[0]

        for i in range(0, tam):
            for j in range(i, tam):
                somaAtual = 0
                for k in range(i, j):
                    somaAtual += vetor[k]
                
                maiorSoma = max(somaAtual, maiorSoma)
        
        return maiorSoma
    

    
    

if __name__ == '__main__':
    #vetor = [31, -41, 59, 26, -53, 58, 97, -93, -23, 84]
    print "#################"
    print "PYTHON"

    caminho = "/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/vetores.txt"
    arq = open(caminho, 'r')
    texto = arq.read()
    linha = ""
    for c in texto:
        if c == '\n':
            vetor = []
            vs = linha.split(" ")
            linha = ""

            for x in vs:
                try:
                    vetor.append(int(x))
                except:
                    print ""

            MaxSubarray(vetor)
        else:
            linha += c

    arq.close()
    