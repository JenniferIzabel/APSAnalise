
class MaxSubarrayAlgorithms

    def max(a, b)
        if a > b 
            return a
        else
            return b
        end
    end

    def dynamicPrograming(vetor)
        maior = vetor[0]
        soma = [vetor.length]
        soma[0] = vetor[0]
        i = 1
        while i < vetor.length
            soma[i] = max(vetor[i], soma[i - 1] + vetor[i])
            maior = max(maior, soma[i])
            i += 1
        end
        return maior
    end

    def somaSubvetor(vetor, primeiro, meio, ultimo)
        somaEsquerda = 0
        soma = 0
        i = meio
        while i >= primeiro
            soma += vetor[i]
            somaEsquerda = max(somaEsquerda, soma)
            i -= 1
        end
        somaDireita = 0
        soma = 0
        i = meio + 1
        while i <= ultimo
            soma += vetor[i]
            somaDireita = max(somaDireita, soma)
            i += 1
        end
        return somaEsquerda + somaDireita
    end

    def maiorDe3(a, b, c)
        if a > b and a > c then
            return a
        elsif b > a and b > c then
            return b
        else
            return c
        end
    end

    def divideAndConquer(vetor, primeiro, ultimo)
        if primeiro == ultimo then
            return vetor[primeiro]
        else
            meio = (primeiro + ultimo) / 2
            return self.maiorDe3(self.divideAndConquer(vetor, primeiro, meio), self.divideAndConquer(vetor, meio + 1, ultimo), self.somaSubvetor(vetor, primeiro, meio, ultimo))
        end
    end

    def betterEnumeration(vetor) 
        tam = vetor.length
        somaAtual = 0
        maiorSoma = 0

        i = 0
        while i < tam
            j = i+1
            while j < tam
                somaAtual = vetor[i]
                k = i+1
                while k < j
                    somaAtual += vetor[k]
                    k += 1
                end
                maiorSoma = max(somaAtual, maiorSoma)
                j += 1
            end
            i += 1
        end  
        
        return maiorSoma
    end

    def enumeration(vetor)
        tam = vetor.length
        maiorSoma = vetor[0]

        i = 0
        while i < tam
            j = i
            while j < tam
                somaAtual = 0
                k = i
                while k < j
                    somaAtual += vetor[k]
                    k +=1
                end
                maiorSoma = max(somaAtual, maiorSoma)
                j += 1
            end
            i += 1
        end
        return maiorSoma
    end

    def executar(vetor)
        string_resultado = "\nVETOR TAMANHO "+vetor.length.to_s

        string_resultado += "\nDynamic Programing -> "
        inicio = Time.now
        res = self.dynamicPrograming(vetor)
        total = Time.now - inicio
        string_resultado += (total*1000).to_i.to_s + " ms"

        string_resultado += "\nDivide and Conquerer -> "
        inicio = Time.now
        res = self.divideAndConquer(vetor, 0, vetor.length-1)
        total = Time.now - inicio
        string_resultado += (total*1000).to_i.to_s + " ms"

        string_resultado += "\nBetter Enumeration -> "
        inicio = Time.now
        res = self.betterEnumeration(vetor)
        total = Time.now - inicio
        string_resultado += (total*1000).to_i.to_s + " ms"

        string_resultado += "\nEnnumeration -> "
        inicio = Time.now
        res = self.enumeration(vetor)
        total = Time.now - inicio
        string_resultado += (total*1000).to_i.to_s + " ms"
        string_resultado += "\n"


        print string_resultado

    end

end

vetor = [31, -41, 59, 26, -53, 58, 97, -93, -23, 84]
msa = MaxSubarrayAlgorithms.new

caminho = "/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/vetores.txt"

puts "#################"
puts "RUBY"

File.open(caminho, 'r') do |f1|
    while linha = f1.gets
        vetor = []
        vs = linha.split(" ")
        linha = ""
        i = 0
        for x in vs
                vetor[i] = x.to_i
                i += 1
        end
        msa.executar(vetor)
    end
end
