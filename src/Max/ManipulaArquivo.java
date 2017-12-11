package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Radames
 */
public class ManipulaArquivo {

    public ManipulaArquivo() {
    }

    public LinkedList<int[]> abrirArquivo(String caminho) {
        File arq = new File(caminho);
        LinkedList<int[]> listaVetores = new LinkedList<>();
        if (arq.exists()) {
            try {
                //OpenFile
                FileReader arquivo = new FileReader(caminho);
                BufferedReader conteudoDoArquivo = new BufferedReader(arquivo);
                String linha = conteudoDoArquivo.readLine();
                while (linha != null) {

                    String[] split = linha.split(" ");
                    int[] vetor = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        vetor[i] = Integer.parseInt(split[i]);
                    }
                    listaVetores.add(vetor);

                    //texto.add(linha);
                    linha = conteudoDoArquivo.readLine();
                }
                conteudoDoArquivo.close();
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo inexistente");;
        }
        return listaVetores;
    }

    public void salvarArquivo(String caminho, LinkedList<int[]> listaVetores) {
        try {
            // Create file 
            FileWriter arquivo = new FileWriter(caminho);
            BufferedWriter conteudoDoArquivo = new BufferedWriter(arquivo);
            for (int[] lista : listaVetores) {
                for (int i : lista) {
                    conteudoDoArquivo.write(i + " ");
                }
                conteudoDoArquivo.write("\n");
            }
            conteudoDoArquivo.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void salvarResultado(String caminho, String resultados) {
        try {
            // Create file 
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(resultados);
            arq.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
