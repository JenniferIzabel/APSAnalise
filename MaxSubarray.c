#include<stdio.h>
#include<time.h>

int max(int a, int b){
    if(a > b) return a;
    else return b;
}

int dynamicPrograming(int vetor[], int tam) {
    int maior = vetor[0];
    int soma[tam];
    soma[0] = vetor[0];

    for (int i = 1; i < tam; i++) {
        soma[i] = max(vetor[i], soma[i - 1] + vetor[i]);
        maior = max(maior, soma[i]);
    }
    return maior;

}

 int somaSubvetor(int vetor[], int primeiro, int meio, int ultimo) {

    int somaEsquerda = -2147483648;
    int soma = 0;

    for (int i = meio; i >= primeiro; i--) {
        soma += vetor[i];
        somaEsquerda = max(somaEsquerda, soma);
    }

    int somaDireita = -2147483648;
    soma = 0;
    for (int i = meio + 1; i <= ultimo; i++) {
        soma += vetor[i];
        somaDireita = max(somaDireita, soma);
    }

    return somaEsquerda + somaDireita;
}

int maiorDe3(int a, int b, int c) {
    if (a > b && a > c) {
        return a;
    } else if (b > a && b > c) {
        return b;
    } else {
        return c;
    }
}

int divideAndConquer(int vetor[], int primeiro, int ultimo) {
    if (primeiro == ultimo) {
        return vetor[primeiro];
    } else {
        int meio = (primeiro + ultimo) / 2;
        return maiorDe3(divideAndConquer(vetor, primeiro, meio),
                divideAndConquer(vetor, meio + 1, ultimo),
                somaSubvetor(vetor, primeiro, meio, ultimo));
    }
}

int betterEnumeration(int vetor[], int tam) {
    int somaAtual = 0;
    int maiorSoma = 0;

    for (int i = 0; i < tam; i++) {
        for (int j = i + 1; j < tam; j++) {
            somaAtual = vetor[i];
            for (int k = i + 1; k < j; k++) {
                somaAtual += vetor[k];
            }
            maiorSoma = max(somaAtual, maiorSoma);
        }
    }
    return maiorSoma;
}

int enumeration(int vetor[], int tam) {
    int somaAtual = 0;
    int maiorSoma = vetor[0];

    for (int i = 0; i < tam; i++) {
        for (int j = i; j < tam; j++) {
            somaAtual = 0;
            for (int k = i; k < j; k++) {
                somaAtual += vetor[k];
            }
            maiorSoma = max(somaAtual, maiorSoma);
        }
    }
    return maiorSoma;
}

char* executa(int vet[], int tam){
    char* str = "";
    int res;

    printf("VETOR TAMANHO %d \n", tam);
    printf ("DynamicPrograming -> ");
    clock_t inicio = clock();
    res = dynamicPrograming(vet, tam);
    clock_t total = (clock() - inicio)*1000/CLOCKS_PER_SEC;
    printf("%ld ms \n", total);

    printf("Divide and Conquer -> ");
    inicio = clock();
    res = divideAndConquer(vet, 0, tam-1);
    total = (clock() - inicio)*1000/CLOCKS_PER_SEC;
    printf("%ld ms \n", total);

    printf("Better Enumeration -> ");
    inicio = clock();
    res = betterEnumeration(vet, tam);
    total = (clock() - inicio)*1000/CLOCKS_PER_SEC;
    printf("%ld ms \n", total);

    printf("Enumeration -> ");
    inicio = clock();
    res = enumeration(vet, tam);
    total = (clock() - inicio)*1000/CLOCKS_PER_SEC;
    printf("%ld ms \n", total);

    printf("\n\n");
}

int main(int argc, char *argv[]){
    int res;

    int tam = 10;
    //int vet[] = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};

    //int tam1 = 128, tam2 = 256, tam3 = 512, tam4 = 1024, tam5 = 2048, tam6 = 4096;
    int tam7 = 8192;
    int* vet;
    //int vet1[tam1], vet2[tam2], vet3[tam3], vet4[tam4], vet5[tam5], vet6[tam6];
    int vet7[tam7];
    int i = 0, ite = 1;
   ///Abrir arquivo e pegar os vetores
    char* caminho = "/home/jennifer/Documents/UTFPR/6º Período/Análise -  3ª triste tentativa/APS/APSAnalise/src/Main/vetores.txt";
    char ch;
	FILE *arq;

	printf("#################\nC\n\n");

	arq = fopen(caminho, "r");
	if(arq == NULL)
	    printf("Erro, nao foi possivel abrir o arquivo\n");
	else
//        vet = vet1;
	    while( (ch=fgetc(arq))!= EOF ){
            if(ch == '\n'){
//                if(ite == 1){
//                    executa(vet1, tam1);
//                }
//                else if(ite == 2){
//                    executa(vet2, tam2);
//                }
//                else if(ite == 3){
//                    executa(vet3, tam3);
//                }
//                else if(ite == 4){
//                    executa(vet4, tam4);
//                }
//                else if(ite == 5){
//                    executa(vet5, tam5);
//                }
//                else if(ite == 6){
//                    executa(vet6, tam6);
//                }
                 if(ite == 1){
                    executa(vet7, tam7);
                }
                ite++;
                i = 0;
            }
//            if(ite == 1){
//                vet1[i++] = (int) ch;
//            }
//            else if(ite == 2){
//                vet2[i++] = (int) ch;
//            }
//            else if(ite == 3){
//                vet3[i++] = (int) ch;
//            }
//            else if(ite == 4){
//                vet4[i++] = (int) ch;
//            }
//            else if(ite == 5){
//                vet5[i++] = (int) ch;
//            }
//            else if(ite == 6){
//                vet6[i++] = (int) ch;
//            }
             if(ite == 1){
                vet7[i++] = (int) ch;
            }
        }
	fclose(arq);
    ///END

}
